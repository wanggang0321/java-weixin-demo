package com.jfsoft.java.weixin.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.jfsoft.java.weixin.demo.config.WxMpConfig;
import com.jfsoft.java.weixin.demo.model.TemplateData;
import com.jfsoft.java.weixin.demo.model.WxTemplate;
import com.jfsoft.java.weixin.demo.util.WeixinUtil;
import me.chanjar.weixin.common.bean.WxAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * @desc 自定义消息推送至指定用户
 * Created by JAVA on 2017/6/7.
 */
@RestController
@RequestMapping("/push")
public class PushMsg {

    @Autowired
    private WxMpConfig wxConfig;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 推送模板消息
     */

    @RequestMapping("/demo")
    public void sendTemplateMessage(String openId, HttpServletRequest request, HttpServletResponse response) throws Exception {

        openId = request.getParameter("openId");

        String appId = this.wxConfig.getAppid();
        String appSecret = this.wxConfig.getAppsecret();
        //获取accessToken | 有效期2小时 | 每日获取次数上限2000次
        WxAccessToken accessToken = WeixinUtil.getAccessToken(appId, appSecret);
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken.getAccessToken();
        WxTemplate wxTemplate = new WxTemplate();
        //模板ID
        wxTemplate.setTemplate_id("TczuFIfdhAqzk4theYB51CPX4NBjO0rY7VEofkDaflQ");
        wxTemplate.setTouser(openId);   //要推送用户的openId
        wxTemplate.setUrl("http://music.163.com/#/song?id=27867140");

        Map<String,TemplateData> m = new HashMap<String,TemplateData>();


        TemplateData first = new TemplateData();
        first.setColor("#000000");
        first.setValue("您好，刚刚测量了血压，结果如下：");
        m.put("first", first);

        TemplateData keyword1 = new TemplateData();
        keyword1.setColor("#000000");
        keyword1.setValue("血压测量 ");
        m.put("keyword1", keyword1);

        TemplateData keyword2 = new TemplateData();
        keyword2.setColor("#000000");
        keyword2.setValue("2016-12-11");
        m.put("keyword2", keyword2);

        TemplateData keyword3 = new TemplateData();
        keyword3.setColor("#000000");
        keyword3.setValue("北京金风易通科技有限公司");
        m.put("keyword3", keyword3);

        /*TemplateData keyword4 = new TemplateData();
        keyword4.setColor("#000000");
        keyword4.setValue("5");
        m.put("keyword4", keyword4);*/

        TemplateData remark = new TemplateData();
        remark.setColor("#000000");
        remark.setValue("高压：120mmHg 低压：80mmHg 心率：75 血压水平：正常");
        m.put("remark", remark);

        wxTemplate.setData(m);
        //将模板信息转为json
        String jsonString = JSONObject.toJSONString(wxTemplate);
        //发送
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonString);
        int result = 0;
        if (null != jsonObject) {
            if (0 != jsonObject.getInteger("errcode")) {
                result = jsonObject.getInteger("errcode");
                log.error("错误 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
            }
        }
        PrintWriter out = response.getWriter();
        out.print(result);
        out.close();
        log.info("模板消息发送结果："+result);
    }
}
