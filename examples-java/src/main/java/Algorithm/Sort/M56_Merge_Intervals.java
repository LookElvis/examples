package Algorithm.Sort;

import LeetCode.PublicClass.Utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by liuxiang on 2019/11/22.
 */
public class M56_Merge_Intervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {-2147483648 , 2},
                {-2147483648 , 2},
                {1, 6},
                {-2147483648 , 1}
        };

        int[][] result = merge(intervals);
        Utils.printIntMatrix(result);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if(o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
//        Utils.printIntMatrix(intervals);

        int pre = intervals[0][0];
        int suf = intervals[0][1] ;
        int[][] result = new int[intervals.length][2];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int p = intervals[i][0];
            int s = intervals[i][1];

            if (p <= suf) {
                suf = Math.max(suf, s);
            } else {
                result[count][0] = pre;
                result[count][1] = suf;
                count++;
                pre = p;
                suf = s;
            }
        }

        result[count][0] = pre;
        result[count][1] = suf;

        return Arrays.copyOf(result, count + 1);
    }
}
