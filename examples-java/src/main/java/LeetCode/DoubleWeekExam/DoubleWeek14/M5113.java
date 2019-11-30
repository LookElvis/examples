package LeetCode.DoubleWeekExam.DoubleWeek14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elvis on 2019/11/30.
 */
public class M5113 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> list = new ArrayList<>();
        int pre = toBeRemoved[0];
        int suf = toBeRemoved[1];

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            List<Integer> tList = new ArrayList<>();
            tList.add(start);
            tList.add(end);
            if (suf <= start) {
                list.add(tList);
                continue;
            }
            if (pre >= end) {
                list.add(tList);
                continue;
            }

            if (start < pre) {
                List<Integer> tList1 = new ArrayList<>();
                tList1.add(start);
                tList1.add(pre);
                list.add(tList1);
                if (suf < end) {
                    List<Integer> tList2 = new ArrayList<>();
                    tList2.add(suf);
                    tList2.add(end);
                    list.add(tList2);
                }
            } else if (start == pre) {
                if (suf < end) {
                    List<Integer> tList2 = new ArrayList<>();
                    tList2.add(suf);
                    tList2.add(end);
                    list.add(tList2);
                }
            } else {
                if (suf < end) {
                    List<Integer> tList2 = new ArrayList<>();
                    tList2.add(suf);
                    tList2.add(end);
                    list.add(tList2);
                }
            }
        }

        return list;
    }
}
