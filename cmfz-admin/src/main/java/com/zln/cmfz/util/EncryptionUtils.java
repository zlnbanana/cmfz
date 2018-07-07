package com.zln.cmfz.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * Created by zhanglijiao on 2018/7/4.
 * 加密
 */
public class EncryptionUtils {

    public static void main(String[] args) {
        String str = "123456abcdef";
        System.out.println(encryptionCodec(str));

    }


    public static String encryptionCodec(String str){
        return DigestUtils.md5Hex(str);//32位
    }

    //随机生成盐
    public static String getRandomSalt(int len){
        char[] chs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(chs[random.nextInt(chs.length)]);
        }
        return builder.toString();

    }

}
