package New.Test3;

import PublicClass.Utils;

import java.util.Scanner;

/**
 * Created by Elvis on 2020/3/5.
 */
public class demo1 {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[2][n];
        String first = input.next();
        String second = input.next();

        for (int i = 0; i < n; i++) {
            if (first.charAt(i) == 'X') {
                matrix[0][i] = 1;
            } else if (first.charAt(i) == '.') {
                matrix[0][i] = 0;
            }
            if (second.charAt(i) == 'X') {
                matrix[1][i] = 1;
            } else if (second.charAt(i) == '.') {
                matrix[1][i] = 0;
            }
        }
//        Utils.printIntMatrix(matrix);
        findPath(matrix, 0, 0);
        System.out.println(count == 0 ? -1 : count);
    }

    public static void findPath(int[][] m, int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] == 1) {
            return;
        }
        if (i == 1 && j == m[i].length - 1) {
            count++;
            return;
        }
        findPath(m, i, j + 1);
        findPath(m, i - 1, j + 1);
        findPath(m, i + 1, j + 1);
    }
}
