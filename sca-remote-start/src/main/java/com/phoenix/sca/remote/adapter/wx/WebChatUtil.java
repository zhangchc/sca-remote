package com.phoenix.sca.remote.adapter.wx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/16 21:32
 */
public class WebChatUtil {

    private static final String TOKEN = "yyw111";
    /**
     * 验证签名的方法
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        List<String> params = new ArrayList<String>();
        params.add(TOKEN);
        params.add(timestamp);
        params.add(nonce);
        // 1. 将token、timestamp、nonce三个参数进行字典序排序
        Collections.sort(params, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // 2.将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));
        // 3. 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return temp.equals(signature);
    }
}
