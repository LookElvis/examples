package New2024;

import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/maximum-difference-score-in-a-grid/
public class August15 {
    public int maxScore(List<List<Integer>> grid) {
        int xLen = grid.size();
        int yLen = grid.get(0).size();

        int [][]f = new int[xLen][2];
        for (int[] row :f) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < xLen; i++) {
            Arrays.fill(f[i & 1], Integer.MAX_VALUE);
            for (int j = 0; j < yLen; j++) {
                int min = Integer.MAX_VALUE;
                // i,j 这个框里的最小值
                if (i > 0) {
                    min = Math.min(min, f[(i-1) & 0][j]);
                }
                if (j > 0) {
                    min = Math.min(min, f[i & 1][j-1]);
                }
                // 奇数为1，偶数为0
                f[i & 1][j] = Math.min(min, grid.get(i).get(j));

                maxScore = Math.max(maxScore, grid.get(i).get(j) - min);
            }
        }

        return maxScore;
    }
}
