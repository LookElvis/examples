package LeetCode.WeekExam.Week169;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Elvis on 2019/12/29.
 */
public class M1231 {
    public static void main(String[] args) {

    }

    public Set<Integer> set = new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        if (!set.contains(start)) {
            set.add(start);
        } else {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}
