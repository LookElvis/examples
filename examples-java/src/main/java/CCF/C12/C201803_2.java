package CCF.C12;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/24.
 */
public class C201803_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int L = input.nextInt();
        int t = input.nextInt();

        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = input.nextInt();
            matrix[i][1] = 1;
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix[j][0] == 0) && (matrix[j][1] == -1)) {
                    matrix[j][1] = 1;
                }
                if ((matrix[j][0] == L) && (matrix[j][1] == 1)) {
                    matrix[j][1] = -1;
                }
                for (int k = j + 1; k < n; k++) {
                    if (matrix[j][0] == matrix[k][0]) {
                        matrix[j][1] = -matrix[j][1];
                        matrix[k][1] = -matrix[k][1];
                    }
                }
            }

            for (int q = 0; q < n; q++) {
                matrix[q][0] += matrix[q][1];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][0] + " ");
        }
    }
}
