package Algorithm.Sort;

import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Elvis on 2019/11/25.
 */
public class H57_Insert_Interval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{3,5},{9,11}};
        int[] newInterval = new int[]{14,25};
        int[][] result = insert(intervals, newInterval);
        Utils.printIntMatrix(result);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        boolean isTrue = false;
        int i = 0;
        for (; i < intervals.length; i++) {
            if (start <= intervals[i][1]) {
                isTrue = true;
                break;
            } else {
                list.add(intervals[i]);
            }
        }
        if (!isTrue) {
            list.add(newInterval);
            return list.toArray(new int[0][]);
        }

        if (end < intervals[i][0]) {
            list.add(newInterval);
        } else {
            int pre = Math.min(start, intervals[i][0]);
            int suf = Math.max(end, intervals[i][1]);
            while (i < intervals.length && end >= intervals[i][0]) {
                suf = Math.max(end, intervals[i][1]);
                i++;
            }
            list.add(new int[]{pre, suf});
        }

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[0][]);
    }
}