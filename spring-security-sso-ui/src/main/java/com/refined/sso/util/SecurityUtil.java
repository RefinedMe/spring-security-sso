package com.refined.sso.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityUtil {

    private static final String ALGORITHM = "AES";
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String secretKeyStr = "zxJ/Pp1A71l5O3dZnIMBFw==";

    /**
     * 生成秘钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String generaterKey() throws NoSuchAlgorithmException {
        KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
        keygen.init(128, new SecureRandom()); // 16 字节 == 128 bit
        //            keygen.init(128, new SecureRandom(seedStr.getBytes())); // 随机因子一样，生成出来的秘钥会一样
        SecretKey secretKey = keygen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * 获取密钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static SecretKeySpec getSecretKeySpec() {
        byte[] secretKey = Base64.getDecoder().decode(secretKeyStr);
        return new SecretKeySpec(secretKey, ALGORITHM);
    }

    /**
     * 加密
     */
    public static String encrypt(String content) throws Exception {
        Key key = getSecretKeySpec();
        Cipher cipher = Cipher.getInstance(ALGORITHM);// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(content.getBytes(DEFAULT_CHARSET));
        return Base64.getEncoder().encodeToString(result);
    }

    /**
     * 解密
     */
    public static String decrypt(String content) throws Exception {
        Key key = getSecretKeySpec();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipher.doFinal(Base64.getDecoder().decode(content));
        return new String(result);
    }
}
