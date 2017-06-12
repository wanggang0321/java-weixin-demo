package com.jfsoft.java.weixin.demo.handler;

import com.jfsoft.java.weixin.demo.builder.TextBuilder;
import com.jfsoft.java.weixin.demo.dao.UserMapper;
import com.jfsoft.java.weixin.demo.model.User;
import com.jfsoft.java.weixin.demo.service.IUserService;
import com.jfsoft.java.weixin.demo.service.WeixinService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 
 * @author ChenXc
 *
 */
@Component
@Controller
public class SubscribeHandler extends AbstractHandler {

  @Autowired
  private IUserService userService;

  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
      WxSessionManager sessionManager) throws WxErrorException {

    this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

    WeixinService weixinService = (WeixinService) wxMpService;

    // 获取微信用户基本信息
    WxMpUser userWxInfo = weixinService.getUserService().userInfo(wxMessage.getFromUser(), null);

    if (userWxInfo != null) {
      try {
        int num = userService.selectUserByOpenID(userWxInfo.getOpenId());
        if(num==0){
          // TODO 可以添加关注用户到本地
          User user = new User();
          user.setSubscribe(userWxInfo.getSubscribe());
          user.setOpenid(userWxInfo.getOpenId());
          user.setSex(userWxInfo.getSex());
          user.setNickname(userWxInfo.getNickname());
          user.setCity(userWxInfo.getCity());
          user.setProvince(userWxInfo.getProvince());
          int i = userService.insert(user);
        }
      }catch (Exception e){
        e.printStackTrace();
      }
    }

    WxMpXmlOutMessage responseResult = null;
    try {
      responseResult = handleSpecial(wxMessage);
    } catch (Exception e) {
      this.logger.error(e.getMessage(), e);
    }

    if (responseResult != null) {
      return responseResult;
    }

    try {
      return new TextBuilder().build("感谢关注", wxMessage, weixinService);
    } catch (Exception e) {
      this.logger.error(e.getMessage(), e);
    }

    return null;
  }

  /**
   * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
   */
  protected WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {
    //TODO
    return null;
  }

}
