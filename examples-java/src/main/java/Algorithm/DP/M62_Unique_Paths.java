package Algorithm.DP;

import java.util.Arrays;

/**
 * Created by Elvis on 2019/12/4.
 */
public class M62_Unique_Paths {
    //时间复杂度为O(n)
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

    //时间复杂度为O(m*n)
    public int uniquePaths1(int m, int n) {
        //初始化
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }

        return dp[m -1][n - 1];
    }
}
