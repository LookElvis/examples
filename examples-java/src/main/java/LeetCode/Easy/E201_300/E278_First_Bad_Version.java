package LeetCode.Easy.E201_300;

/**
 * https://leetcode.com/problems/first-bad-version/description/
 * https://leetcode.com/problems/first-bad-version/solution/
 * Created by liuxiang on 2018/10/31.
 */
public class E278_First_Bad_Version {
    public static void main(String[] args) {

    }

    public static boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }
}
