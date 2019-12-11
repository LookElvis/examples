package Algorithm.DP;

/**
 * Created by Elvis on 2019/12/11.
 */
public class M264_Ugly_Number_Two {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        int dp2 = 0;
        int dp3 = 0;
        int dp5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[dp2] * 2, dp[dp3] * 3), dp[dp5] * 5);
            if (dp[i] == dp[dp2] * 2) dp2++;
            if (dp[i] == dp[dp3] * 3) dp3++;
            if (dp[i] == dp[dp5] * 5) dp5++;
        }
        return dp[n - 1];
    }
}
