package New.Test7;

import java.util.*;

/**
 * Created by Elvis on 2020/4/7.
 */
public class demo4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 行数
        int m = input.nextInt(); // 数字个数
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String t = input.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = t.charAt(j) - '0';
            }
        }

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    res[i][j] = 0;
                } else {
//                    res[i][j] = bfs(arr, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            if (i < n - 1) {
                System.out.println();
            }
        }
    }

//    public static int bfs(int[][] arr, int i, int j) {
//        int count = 0;
//        Queue<Point> queue = new ArrayDeque<>();
//        int[][] isVisit = new int[arr.length][arr[i].length];
//        isVisit[i][j] = 1;
//        queue.add(new Point(i, j));
//        while (!queue.isEmpty()) {
//            int len = queue.size();
//            Point t = queue.poll();
//            int l = t.x;
//            int r = t.y;
//            count++;
//            for (int mm = 0; mm < len; mm++) {
//
//
//
//
//            }
//        }
//    }

}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
