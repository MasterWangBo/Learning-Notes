package com.smartdot.mobile.portal.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Encoder;

/**
 * AES加密（金川专用） Created by zhang on 2017/2/23.
 */

public class MyAesUtil {

    /**
     * AES 128 加密
     * 
     * @param sourceString
     * @return
     */
    public static String encrypt128(String sourceString) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// 创建密码
            SecretKeySpec key = new SecretKeySpec("hebfqxmqxhxg24pk".getBytes(), "AES");
            IvParameterSpec iv = new IvParameterSpec("ayub9icy3t5ui8p6".getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] result = cipher.doFinal(sourceString.getBytes());
            return new BASE64Encoder().encode(result); // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
