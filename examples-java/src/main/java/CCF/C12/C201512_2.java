package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/20.
 */
public class C201512_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();

        int[][] matrix1 = new int[row][col];
        int[][] matrix2 = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix1[i][j] = input.nextInt();
                matrix2[i][j] = matrix1[i][j];
            }
        }

        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                //行判定
                int count1 = 0;
                for (int k = n + 1; k < col; k++) {
                    if (matrix1[m][n] == matrix1[m][k]) {
                        count1++;
                    } else {
                        break;
                    }
                }

                if (count1 >= 2) {
                    for (int g = 0; g <= count1; g++) {
                        matrix2[m][n + g] = 0;
                    }
                }

                //列判定
                int count2 = 0;
                for (int k = m + 1; k < row; k++) {
                    if (matrix1[m][n] == matrix1[k][n]) {
                        count2++;
                    } else {
                        break;
                    }
                }

                if (count2 >= 2) {
                    for (int g = 0; g <= count2; g++) {
                        matrix2[m + g][n] = 0;
                    }
                }
            }
        }

        for (int a = 0; a < row; a++) {
            for (int b = 0; b < col; b++) {
                System.out.print(matrix2[a][b] + " ");
            }
            System.out.println();
        }
    }
}
