package org.yxm.jundui.util;

import java.util.List;

/**
 * Created by yxm on 2016.11.28.
 */
public class ArrayUtils {
    public static Integer[] list2Array(List<Integer> datas) {
        Integer[] nums = new Integer[datas.size()];
        for (int i = 0; i < datas.size(); i++) {
            nums[i] = datas.get((int) i);
        }
        return nums;
    }
}
