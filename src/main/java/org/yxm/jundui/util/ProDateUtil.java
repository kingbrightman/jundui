package org.yxm.jundui.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yxm on 2016.12.21.
 */
public class ProDateUtil {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd-HH-mm-ss";

    public static String getCurrentDateFileName(String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(new Date()).toString();
    }
}
