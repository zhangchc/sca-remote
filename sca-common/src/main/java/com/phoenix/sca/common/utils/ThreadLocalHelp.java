package com.phoenix.sca.common.utils;


import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalHelp {

    public static final String CURRENT_USER_ID = "currentUserId";

    public static final String CURRENT_AUTH_TOKEN = "currentAuthToken";

    public static final String CURRENT_USER_NAME = "currentUserName";


    private static InheritableThreadLocal<Map<String, Object>> threadLocal = new InheritableThreadLocal() {
        @Override
        protected Object initialValue() {
            return new HashMap<>();
        }
    };

    /**
     * 获取当前用户ID
     *
     * @return
     */
    public static Long getCurrentUserId() {
        return MapUtils.getLong(threadLocal.get(), CURRENT_USER_ID);
    }


    /**
     * 获取Token
     *
     * @return
     */
    public static String getCurrentAuthToken() {
        return MapUtils.getString(threadLocal.get(), CURRENT_AUTH_TOKEN);
    }

    /**
     * 获取UserName
     *
     * @return
     */
    public static String getCurrentUserName() {
        return MapUtils.getString(threadLocal.get(), CURRENT_USER_NAME);
    }

    public static void setCurrentUserId(Long currentUserId) {
        threadLocal.get().put(CURRENT_USER_ID, currentUserId);
    }

    public static void setCurrentAuthToken(String currentAuthToken) {
        threadLocal.get().put(CURRENT_AUTH_TOKEN, currentAuthToken);
    }

    public static void setCurrentUserName(String currentUserName) {
        threadLocal.get().put(CURRENT_USER_NAME, currentUserName);
    }

    public static void remove() {
        if (threadLocal == null) {
            return;
        }
        threadLocal.remove();
    }
}
