package org.yxm.jundui.util;

import org.yxm.jundui.model.GradeLevel;

/**
 * Created by yxm on 2016.12.07.
 */
public class GradeLevelUtil {

    //计算整型成绩
    public static String calculateINT(String content, GradeLevel level) {
        int con = Integer.parseInt(content);
        if (!isNullOrEmpty(level.yfrom) && !isNullOrEmpty(level.yto)) {
            if (con >= Integer.parseInt(level.yfrom) && con <= Integer.parseInt(level.yto)) {
                return GradeLevel.Y;
            }
        }
        if (!isNullOrEmpty(level.lfrom) && !isNullOrEmpty(level.lto)) {
            if (con >= Integer.parseInt(level.lfrom) && con <= Integer.parseInt(level.lto)) {
                return GradeLevel.L;
            }
        }
        if (!isNullOrEmpty(level.zfrom) && !isNullOrEmpty(level.zto)) {
            if (con >= Integer.parseInt(level.zfrom) && con <= Integer.parseInt(level.zto)) {
                return GradeLevel.Z;
            }
        }
        if (!isNullOrEmpty(level.cfrom) && !isNullOrEmpty(level.cto)) {
            if (con >= Integer.parseInt(level.cfrom) && con <= Integer.parseInt(level.cto)) {
                return GradeLevel.C;
            }
        }
        return GradeLevel.ERROR;
    }

    //计算小数型成绩
    public static String calculateFLOAT(String content, GradeLevel level) {
        Double con = Double.parseDouble(content);
        if (!isNullOrEmpty(level.yfrom) && !isNullOrEmpty(level.yto)) {
            if (con >= Double.parseDouble(level.yfrom) && con <= Double.parseDouble(level.yto)) {
                return GradeLevel.Y;
            }
        }
        if (!isNullOrEmpty(level.lfrom) && !isNullOrEmpty(level.lto)) {
            if (con >= Double.parseDouble(level.lfrom) && con <= Double.parseDouble(level.lto)) {
                return GradeLevel.L;
            }
        }
        if (!isNullOrEmpty(level.zfrom) && !isNullOrEmpty(level.zto)) {
            if (con >= Double.parseDouble(level.zfrom) && con <= Double.parseDouble(level.zto)) {
                return GradeLevel.Z;
            }
        }
        if (!isNullOrEmpty(level.cfrom) && !isNullOrEmpty(level.cto)) {
            if (con >= Double.parseDouble(level.cfrom) && con <= Double.parseDouble(level.cto)) {
                return GradeLevel.C;
            }
        }
        return GradeLevel.ERROR;
    }

    //计算分+秒型成绩
    public static String calculateTIME(String content, GradeLevel level) {
        int seconds = getSeconds(content);

        if (!isNullOrEmpty(level.yfrom) && !isNullOrEmpty(level.yto)) {
            int yfrom = getSeconds(level.yfrom);
            int yto = getSeconds(level.yto);
            if (seconds >= yfrom && seconds <= yto) return GradeLevel.Y;
        }

        if (!isNullOrEmpty(level.lfrom) && !isNullOrEmpty(level.lto)) {
            int lfrom = getSeconds(level.lfrom);
            int lto = getSeconds(level.lto);
            if (seconds >= lfrom && seconds <= lto) return GradeLevel.L;
        }

        if (!isNullOrEmpty(level.zfrom) && !isNullOrEmpty(level.zto)) {
            int zfrom = getSeconds(level.zfrom);
            int zto = getSeconds(level.zto);
            if (seconds >= zfrom && seconds <= zto) return GradeLevel.Z;
        }

        if (!isNullOrEmpty(level.cfrom) && !isNullOrEmpty(level.cto)) {
            int cfrom = getSeconds(level.cfrom);
            int cto = getSeconds(level.cto);
            if (seconds >= cfrom && seconds <= cto) return GradeLevel.C;
        }

        return GradeLevel.ERROR;
    }

    //获得秒数
    public static int getSeconds(String content) {
        int seconds = 0;
        //最小分钟
        if (content.contains("'")) {
            String[] ms = content.split("'");
            //分开之后只有一个数字
            if (ms.length == 1) {
                //只包含秒，还输入了 ''
                if (content.contains("''")) {
                    seconds += Integer.parseInt(ms[0]);
                }
                //只包含分
                else {
                    seconds += Integer.parseInt(ms[0]) * 60;
                }
            }
            //包含分秒
            else {
                seconds += Integer.parseInt(ms[0]) * 60 + Integer.parseInt(ms[1]);
            }
        }
        //没有任何 '，只包含秒
        else {
            seconds += Integer.parseInt(content);
        }
        return seconds;
    }

    //计算毫秒型成绩
    public static String calculateMSEC(String content, GradeLevel level) {
        int mesc = getMesc(content);

        if (!isNullOrEmpty(level.yfrom) && !isNullOrEmpty(level.yto)) {
            int yfrom = getMesc(level.yfrom);
            int yto = getMesc(level.yto);
            if (mesc >= yfrom && mesc <= yto) return GradeLevel.Y;
        }

        if (!isNullOrEmpty(level.lfrom) && !isNullOrEmpty(level.lto)) {
            int lfrom = getMesc(level.lfrom);
            int lto = getMesc(level.lto);
            if (mesc >= lfrom && mesc <= lto) return GradeLevel.L;
        }

        if (!isNullOrEmpty(level.zfrom) && !isNullOrEmpty(level.zto)) {
            int zfrom = getMesc(level.zfrom);
            int zto = getMesc(level.zto);
            if (mesc >= zfrom && mesc <= zto) return GradeLevel.Z;
        }

        if (!isNullOrEmpty(level.cfrom) && !isNullOrEmpty(level.cto)) {
            int cfrom = getMesc(level.cfrom);
            int cto = getMesc(level.cto);
            if (mesc >= cfrom && mesc <= cto) return GradeLevel.C;
        }

        return GradeLevel.ERROR;
    }

    //计算毫秒
    public static int getMesc(String content) {
        int mesc = 0;
        //最小分钟
        if (content.contains("''")) {
            String[] ms = content.split("''");
            //分开之后只有一个数字
            if (ms.length == 1) {
                //只包含秒
                mesc += Integer.parseInt(ms[0]) * 100;
            }
            //包含秒+毫秒
            else {
                mesc += Integer.parseInt(ms[0]) * 100 + Integer.parseInt(ms[1]);
            }
        }
        //没有任何 ''，只包含毫秒
        else {
            mesc += Integer.parseInt(content);
        }
        return mesc;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
