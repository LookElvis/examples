package Algorithm.CCF.C3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/11.
 */
public class C201512 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String f = input.nextLine();
        int m = Integer.parseInt(f.split(" ")[0]);
        int n = Integer.parseInt(f.split(" ")[1]);
        int q = Integer.parseInt(f.split(" ")[2]);

        String[] line = new String[q];
        for (int i = 0; i < q; i++) {
            line[i] = input.nextLine();
        }

        //画框框
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = n + 1; i >= 0; i--) {
            for (int j = 0; j < m + 2; j++) {
                boolean tt = ((i == 0) || (i == n + 1) || (j == 0) || (j == m + 1));
                matrix[j][i] = tt ? '+' : '.';
            }
        }

//        for (int i = n + 1; i >= 0; i--) {
//            for (int j = 0; j < m + 2; j++) {
//                System.out.print((char) matrix[j][i] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int i = 0; i < q; i++) {
            String t1 = line[i];
            String[] ll = t1.split(" ");
            int isOne = Integer.parseInt(ll[0]);
            int a = Integer.parseInt(ll[1]) + 1;
            int b = Integer.parseInt(ll[2]) + 1;

            //划线
            if (isOne == 0) {
                int c = Integer.parseInt(ll[3]) + 1;
                int d = Integer.parseInt(ll[4]) + 1;
                if (a == c) {
                    if (b > d) {
                        int t = b;
                        b = d;
                        d = t;
                    }

                    for (int j = b; j <= d; j++) {
                        matrix[a][j] = (matrix[a][j] == '-' ? '+' : '|');
                    }
                } else if (b == d) {
                    if (a > c) {
                        int t = a;
                        a = c;
                        c = t;
                    }

                    for (int j = a; j <= c; j++) {
                        matrix[j][b] = (matrix[j][b] == '|' ? '+' : '-');
                    }
                }
            } else { //填充
                int c = ll[3].charAt(0);
                add(matrix, a, b, c);
            }
        }

        for (int dd = n; dd > 0; dd--) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print((char) matrix[j][dd]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void add(int[][] mat, int i, int j, int num) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        while (!queue.isEmpty()) {
            int ii = queue.peek().x;
            int jj = queue.peek().y;
            mat[ii][jj] = num;
            queue.remove();
            //可填充
            if (isT(mat, ii + 1, jj, num)) {
                queue.offer(new Point(ii + 1, jj));
            }

            if (isT(mat, ii - 1, jj, num)) {
                queue.offer(new Point(ii - 1, jj));
            }

            if (isT(mat, ii, jj + 1, num)) {
                queue.offer(new Point(ii, jj + 1));
            }

            if (isT(mat, ii, jj - 1, num)) {
                queue.offer(new Point(ii, jj - 1));
            }
        }
    }

    public static boolean isT(int[][] mat, int ii, int jj, int num) {
        return (mat[ii][jj] != '+' && mat[ii][jj] != '-' && mat[ii][jj] != '|' && mat[ii][jj] != num);
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


//16 13 9
//0 3 1 12 1
//0 12 1 12 3
//0 12 3 6 3
//0 6 3 6 9
//0 6 9 12 9
//0 12 9 12 11
//0 12 11 3 11
//0 3 11 3 1
//1 4 2 C
