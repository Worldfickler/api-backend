package com.fickler.apiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author dell
 * @date 2023/5/22 16:27
 */
public class SingUtils {

    /**
     * 生成签名
     * @param body 用户参数
     * @param secretKey 密钥
     * @return 不可解密的值
     */
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + '.' + secretKey;
        return md5.digestHex(content);
    }

}
