package LeetCode.Easy.E301_400;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * https://leetcode.com/submissions/detail/187954344/
 * Created by liuxiang on 2018/11/7.
 */
public class E374_Guess_Number_Higher_or_Lower {
    public static void main(String[] args) {
        int n = 10;
        int result = guessNumber(n);
        System.out.println(result);
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int temp = guess(mid);
            if (temp == 0) {
                return mid;
            } else if (temp == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return n;
    }

    public static int guess(int num) {
        int pick = 6;
        if (num == pick) {
            return 0;
        } else if (num < pick) {
            return 1;
        } else {
            return -1;
        }
    }
}
