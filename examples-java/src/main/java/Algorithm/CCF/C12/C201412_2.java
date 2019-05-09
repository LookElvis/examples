package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/19.
 */
public class C201412_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int j = 0;
        int k = 0;

        System.out.print(matrix[j][k] + " ");
        while (!((j == n - 1) && (k == n - 1))) {

            if (k + 1 < n) {
                k++;
            } else {
                j++;
            }
            System.out.print(matrix[j][k] + " ");

            do {
                j++;
                k--;
                System.out.print(matrix[j][k] + " ");
            } while (k > 0 && (j + 1) < n);

            if (j + 1 < n) {
                j++;
            } else {
                k++;
            }
            System.out.print(matrix[j][k] + " ");

            if (j == (n - 1) && k == (n - 1)) {
                break;
            }

            do {
                j--;
                k++;
                System.out.print(matrix[j][k] + " ");
            } while (j > 0 && (k + 1) < n);
        }
    }
}
