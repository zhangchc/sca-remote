package com.phoenix.sca.remote.adapter.wx;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/16 21:51
 */
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParse {

    public static Map<String, String> parseXml(HttpServletRequest request)
            throws Exception {
        Map<String, String> map = new HashMap<>();
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            for (Element e : elementList) {
                map.put(e.getName(), e.getText());
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return map;
    }

    /**
     * 将请求request 转化为json
     *
     * @param request config
     * @return 返回结果
     * @throws IOException 跑出异常
     */
    public static JSONObject parseJson(HttpServletRequest request) throws IOException {
        //post方式传递读取字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonStr = null;
        StringBuilder result = new StringBuilder();
        while ((jsonStr = reader.readLine()) != null) {
            result.append(jsonStr);
        }
        // 关闭输入流
        reader.close();
        // 取一个json转换为对象
        return JSONObject.parseObject(result.toString());
    }
}
