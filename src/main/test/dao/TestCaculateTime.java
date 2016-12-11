package dao;

import org.junit.Test;
import org.yxm.jundui.model.GradeLevel;
import org.yxm.jundui.model.SystemContext;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yxm on 2016.12.07.
 */
public class TestCaculateTime {

    @Test
    public void test1() {
        List<String> contents = new ArrayList<>();
        contents.add("30''");
        contents.add("4'09");
        contents.add("3'60''");
        contents.add("40'12");

        GradeLevel level = new GradeLevel("0'", "4'", "4'", "6'", "6'", "7'", "7'", "60'");

        for (String item : contents) {
            System.out.println(calculateTIME(item, level));
        }
    }

    @Test
    public void test2(){
        String str1 = "hello＇＇world";
        String str2 = "h‘’world";
        System.out.println(str1.replace("＇＇", "''"));
        System.out.println(str2.replace("‘’", "''"));
    }

    private String calculateTIME(String content, GradeLevel level) {
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

    int getSeconds(String content) {
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
                else{
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

    boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
