package com.jfsoft.java.weixin.demo.builder;

import com.jfsoft.java.weixin.demo.service.WeixinService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;

/**
 * 
 * @author ChenXc
 *
 */
public class TextBuilder extends AbstractBuilder {

  @Override
  public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage,
      WeixinService service)   {
    WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content(content)
        .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
        .build();
    return m;
  }

}
