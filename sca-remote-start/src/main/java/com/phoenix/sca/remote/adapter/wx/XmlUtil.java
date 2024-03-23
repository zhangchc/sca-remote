package com.phoenix.sca.remote.adapter.wx;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/3/16 21:54
 */
import org.apache.commons.lang3.StringUtils;
import org.ehcache.core.util.CollectionUtil;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Map.Entry;

/**
 * 封装和处理xml文件
 * @author Administrator
 *
 */
public class XmlUtil {

    private static final String PREFIX_XML = "<xml>";

    private static final String SUFFIX_XML = "</xml>";

    private static final String PREFIX_CDATA = "<![CDATA[";

    private static final String SUFFIX_CDATA = "]]>";

    /**
     * 转化成xml, 单层无嵌套
     *
     * @param parm
     * @param isAddCDATA  ture 加CDATA标签  false 不加CDATA标签
     * @return
     */
    public static String xmlFormat(Map<String, String> parm, boolean isAddCDATA) {

        StringBuffer strbuff = new StringBuffer(PREFIX_XML);
        if (!CollectionUtils.isEmpty(parm)) {
            for (Entry<String, String> entry : parm.entrySet()) {
                strbuff.append("<").append(entry.getKey()).append(">");
                if (isAddCDATA) {
                    strbuff.append(PREFIX_CDATA);
                    if (StringUtils.isNotEmpty(entry.getValue())) {
                        strbuff.append(entry.getValue());
                    }
                    strbuff.append(SUFFIX_CDATA);
                } else {
                    if (StringUtils.isNotEmpty(entry.getValue())) {
                        strbuff.append(entry.getValue());
                    }
                }
                strbuff.append("</").append(entry.getKey()).append(">");
            }
        }
        return strbuff.append(SUFFIX_XML).toString();
    }

}
