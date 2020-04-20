package Common.AlgrithmTest;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Elvis on 2020/2/29.
 */
public class ColoredProblem {
    public static void main(String[] args) {
        int[][] m = new int[][] {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    count++;
                    change(m, i, j);
                }
            }
        }
        System.out.println(count);
    }

    // 递归方法
    public static void change(int[][] m, int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[i].length || m[i][j] != 1 || m[i][j] == 2) {
            return;
        }
        m[i][j] = 2;
        change(m, i - 1, j);
        change(m, i + 1, j);
        change(m, i, j - 1);
        change(m, i, j + 1);
    }

    // 非递归方法
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];
        int res = 0;

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 没被访问过并且为1
                Queue<int[]> queue = new ArrayDeque<>();
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    res++;
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] t = queue.poll();
                        int tx = t[0];
                        int ty = t[1];
                        int x, y;
                        for (int k = 0; k < 4; k++) {
                            x = tx + dx[k];
                            y = ty + dy[k];
                            if (x >= 0 && x < row && y >= 0 && y < col && visited[x][y] == 0) {
                                visited[x][y] = 1;
                                if (grid[x][y] == '1') {
                                    queue.add(new int[] {x, y});
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
