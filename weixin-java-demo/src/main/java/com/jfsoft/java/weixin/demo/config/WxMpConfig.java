package com.jfsoft.java.weixin.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author ChenXc
 * @desc 获取微信公众号的基本信息
 *
 */
@Configuration
public class WxMpConfig {
  @Value("#{wxProperties.wx_token}")
  private String token;

  @Value("#{wxProperties.wx_appid}")
  private String appid;

  @Value("#{wxProperties.wx_appsecret}")
  private String appsecret;

  @Value("#{wxProperties.wx_aeskey}")
  private String aesKey;

  public String getToken() {
    return this.token;
  }

  public String getAppid() {
    return this.appid;
  }

  public String getAppsecret() {
    return this.appsecret;
  }

  public String getAesKey() {
    return this.aesKey;
  }

}
