package LeetCode.WeekExam.Week167;

import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elvis on 2019/12/15.
 */
public class M1291 {
    public static void main(String[] args) {
        sequentialDigits(100, 300);
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        int count = 8;
        int start = 12;
        int gap = 11;
        int now = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = count; i > 0; i--) {
            now = start;
            for (int j = i; j > 0; j--) {
                list.add(now);
                now += gap;
            }
            gap = gap * 10 + 1;
            start = start + gap;
        }
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= low && list.get(i) <= high) {
                r.add(list.get(i));
            } else if (list.get(i) > high) {
                return r;
            }
        }
        return r;
    }
}
