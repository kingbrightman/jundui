package org.yxm.jundui.util;

/**
 * Created by yxm on 2016.12.21.
 */
public class ProString {
    public static boolean isBlank(String id) {
        if (id == null || id.trim().length() < 1) {
            return false;
        }
        return true;
    }
}
