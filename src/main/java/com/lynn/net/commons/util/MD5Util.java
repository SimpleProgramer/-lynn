package com.lynn.net.commons.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5工具类
 *
 * @author wangjianbin
 * @create 2017-08-01 14:22
 **/
public class MD5Util {


    public static String getMD5(String source){
        return DigestUtils.md5Hex(source);
    }

}
