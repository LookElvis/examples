package New.Test6;


import PublicClass.Utils;

import java.util.Scanner;

/**
 * Created by Elvis on 2020/4/1.
 */
public class demo3 {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "surprise", "happy", "ctrip",
                "travel", "wellcome","student",
                "system","program","editor"
        };
        Scanner input = new Scanner(System.in);
        String t = input.next();
        int countOp;
        boolean isRight = false;
        for (int i = 0; i < strings.length; i++) {
            countOp = minDistance(t, strings[i]);
            if (countOp <= 2) {
                isRight = true;
                System.out.println(strings[i]);
            }
        }
        if (!isRight) {
            System.out.println("null");
        }
    }

    public static int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        //dp[i][j]代表source到i为止的字符串 -> target到j为止的字符串所需要变化的次数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        char t1, t2;
        for (int i = 1; i <= m; i++) {
            t1 = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                t2 = s2.charAt(j - 1);
                if (t1 == t2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i -1][j - 1]) + 1;
                }
            }
        }
        Utils.printIntMatrix(dp);
        return dp[m][n];
    }
}
