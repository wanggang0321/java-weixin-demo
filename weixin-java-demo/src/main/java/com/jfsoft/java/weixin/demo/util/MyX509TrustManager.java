package com.jfsoft.java.weixin.demo.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/**
 * Created by JAVA on 2017/6/8.
 */
public class MyX509TrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {

//  TODO Auto-generated method stub


    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {

//  TODO Auto-generated method stub


    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {

//  TODO Auto-generated method stub
        return null;

    }
}
