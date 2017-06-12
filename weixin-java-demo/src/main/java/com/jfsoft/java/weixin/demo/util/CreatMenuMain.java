package com.jfsoft.java.weixin.demo.util;

import com.jfsoft.java.weixin.demo.model.Button;
import com.jfsoft.java.weixin.demo.model.CommonButton;
import com.jfsoft.java.weixin.demo.model.ComplexButton;
import com.jfsoft.java.weixin.demo.model.Menu;
import me.chanjar.weixin.common.bean.WxAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by JAVA on 2017/6/8.
 * @desc 创建自定义菜单
 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单
 * 一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替
 */
public class CreatMenuMain {
    /**
     * 创建自定义菜单方法
     * @param args
     */
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(CreatMenuMain.class);
        String appId = "wx353e13844287f767";
        String appSecret = "cdd49c3240e17af54ec67566a019d56a";
        //获取accessToken | 有效期2小时 | 每日获取次数上限2000次
        WxAccessToken accessToken = WeixinUtil.getAccessToken(appId, appSecret);
        if (null != accessToken) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), accessToken.getAccessToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);

        }
    }


    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("天气预报");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12 = new CommonButton();
        btn12.setName("公交查询");
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn13 = new CommonButton();
        btn13.setName("周边搜索");
        btn13.setType("click");
        btn13.setKey("13");

        CommonButton btn14 = new CommonButton();
        btn14.setName("历史上的今天");
        btn14.setType("click");
        btn14.setKey("14");

        CommonButton btn21 = new CommonButton();
        btn21.setName("歌曲点播");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22 = new CommonButton();
        btn22.setName("经典游戏");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn23 = new CommonButton();
        btn23.setName("美女电台");
        btn23.setType("click");
        btn23.setKey("23");

        CommonButton btn24 = new CommonButton();
        btn24.setName("人脸识别");
        btn24.setType("click");
        btn24.setKey("24");

        CommonButton btn25 = new CommonButton();
        btn25.setName("聊天唠嗑");
        btn25.setType("click");
        btn25.setKey("25");

        CommonButton btn31 = new CommonButton();
        btn31.setName("Q友圈");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("电影排行榜");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("幽默笑话");
        btn33.setType("click");
        btn33.setKey("33");


        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("生活助手");
        //一级下有4个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });


        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("休闲驿站");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });


        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("更多体验");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });


        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}
