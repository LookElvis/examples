package New.Test15;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 网易严选秋招笔试
 * Created by Elvis on 2020/8/8.
 */
public class demo3_1 {
    public static int max = 0;
    public static HashSet set = new HashSet<>();
    public static HashSet five = new HashSet<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        helper(arr, 0, 0);
        System.out.println(max);
    }

    public static void helper(int[] arr, int start, int cnt) {
        if (start == arr.length) {
            if (!containFive(cnt)) {
                max = Math.max(max, cnt);
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            cnt += arr[start];
            if (!set.contains(cnt)) {
                helper(arr, start + 1, cnt);
            }
            set.add(cnt);
            cnt -= arr[start];
            if (!set.contains(cnt)) {
                helper(arr, start + 1, cnt);
            }
            set.add(cnt);
        }
    }

    public static boolean containFive(int s) {
        while (s != 0) {
            if (s % 10 == 5) return true;
            s /= 10;
        }
        return false;
    }
}
