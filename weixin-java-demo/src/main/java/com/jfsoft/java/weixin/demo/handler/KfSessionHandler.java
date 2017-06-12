package com.jfsoft.java.weixin.demo.handler;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 
 * @author ChenXc
 * @// TODO: 2017/6/6 会话应答
 *
 */
@Component
public class KfSessionHandler extends AbstractHandler{

  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) {
    //wxMessage 消息 | context 上下文 | WxService API对象
    //TODO 对会话做处理


    return null;
  }

}
