package com.runnersoftware.hot_pot_shop.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * xml中配置bean一定要有这个默认空的构造器
 * @author
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AliOssProperties implements Serializable, InitializingBean {

    public static String ENDPOINT;

    @Value("${alioss.endPoint}")
    public String endPoint;

    @Value("${alioss.bucketName}")
    private String bucketName;

    public static String BUCKETNAME;

    @Value("${alioss.keyId}")
    private String keyId;

    public static String KEYID;

    @Value("${alioss.keySecret}")
    private String keySecret;

    public static String KEYSECRET;


    @Override
    public void afterPropertiesSet() throws Exception{
        ENDPOINT = endPoint;
        BUCKETNAME = bucketName;
        KEYID = keyId;
        KEYSECRET = keySecret;
    }
}
