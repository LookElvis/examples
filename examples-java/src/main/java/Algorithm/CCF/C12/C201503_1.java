package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/20.
 */
public class C201503_1 {

    public static int[][] m1 = new int[1000][1000];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();

//        int[][] m1 = new int[row][col];
        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m1[i][j] = input.nextInt();
            }
        }

        for (int a = col - 1; a >= 0; a--) {
            for (int n = 0; n < row; n++) {
                System.out.print(m1[n][a] + " ");
            }
            System.out.println();
        }

//        int[] m = new int[row * col];
//        for (int i = 0; i < m.length; i++) {
//            m[i] = input.nextInt();
//        }
//
//        for (int a = col; a > 0; a--) {
//            for (int n = 1; n <= row; n++) {
//                int t = (n - 1) * col + a - 1;
//                System.out.print(m[t] + " ");
//            }
//            System.out.println();
//        }
    }
}
