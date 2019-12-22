package LeetCode.WeekExam.Week165;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuxiang on 2019/11/24.
 */
public class M1277 {
    public static void main(String[] args) {

    }

    public int countSquares(int[][] matrix) {
        int count = 0;
        Point[][] limit = new Point[matrix.length+1][matrix[0].length+1];
        Arrays.fill(limit, new Point(0, 0));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int t = matrix[i][j];
                if (t == 1) {
                    int x1 = limit[i+1][j].x + 1;
                    int y1 = limit[i+1][j].y + 1;
                    int x2 = limit[i][j+1].x + 1;
                    int y2 = limit[i][j+1].y + 1;
                    if (x1 == x2 && y1 == y2) {

                    }
                    limit[i+1][j+1] = new Point(x1, y2);
                }
            }
        }
        return count;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
