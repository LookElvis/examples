package Algorithm.DP;

/**
 * Created by Elvis on 2019/12/4.
 */
public class M63_Unique_Paths_Two {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        //初始化
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = obstacleGrid[0][i] == 0 ? dp[i-1] : 0;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[0] = obstacleGrid[i][0] == 0 ? dp[0] : 0;
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                dp[j] = obstacleGrid[i][j] == 0 ? (dp[j] + dp[j - 1]) : 0;
            }
        }
        return dp[dp.length - 1];
    }
}
