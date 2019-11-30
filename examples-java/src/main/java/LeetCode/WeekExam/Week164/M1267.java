package LeetCode.WeekExam.Week164;

import LeetCode.PublicClass.Utils;

/**
 * Created by liuxiang on 2019/11/24.
 */
public class M1267 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1}
        };
        System.out.println(countServers(grid));
    }

    public static int countServers(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (row[i] >= 2 || col[j] >= 2)) {
                    count++;
                }
            }
        }

        return count;
    }
}
