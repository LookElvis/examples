package LeetCode.WeekExam.Week169;

import LeetCode.PublicClass.Utils;

/**
 * Created by Elvis on 2019/12/29.
 */
public class E1299 {
    public static void main(String[] args) {
        int[] arr = sumZero(4);
        Utils.printIntArrays(arr);
    }

    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        int j = 0;
        if ((n & 1) == 0) {
            for (int i = -n/2; i <= n/2; i++) {
                if (i != 0) {
                    arr[j] = i;
                    j++;
                }
            }
        } else {
            for (int i = -n/2; i <= n/2; i++) {
                arr[j] = i;
                j++;

            }
        }
        return arr;
    }
}
