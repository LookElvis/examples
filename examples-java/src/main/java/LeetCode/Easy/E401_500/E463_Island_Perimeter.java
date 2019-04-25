package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

/**
 * https://leetcode.com/problems/island-perimeter/
 * https://leetcode.com/submissions/detail/190617333/
 * Created by liuxiang on 2018/11/20.
 */
public class E463_Island_Perimeter {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 1, 0, 0}};
        int result = islandPerimeter(grid);
        System.out.println(result);
    }

    public static int islandPerimeter(int[][] grid) {
        int[][] newGrid = new int[grid.length + 2][grid[0].length + 2];
        for (int m = 1; m < newGrid.length - 1; m++) {
            for (int n = 1; n < newGrid[0].length - 1; n++) {
                newGrid[m][n] = grid[m - 1][n - 1];
            }
        }
        Utils.printIntMatrix(newGrid);

        int count = 0;
        for (int i = 1; i < newGrid.length - 1; i++) {
            for (int j = 1; j < newGrid[0].length - 1; j++) {
                if (newGrid[i][j] == 1) {
                    if (newGrid[i][j - 1] == 0) {
                        count++;
                    }
                    if (newGrid[i][j + 1] == 0) {
                        count++;
                    }
                    if (newGrid[i - 1][j] == 0) {
                        count++;
                    }
                    if (newGrid[i + 1][j] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
