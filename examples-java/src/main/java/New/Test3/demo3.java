package New.Test3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demo3 {
    public static int MaxValue = 100000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = input.nextInt();
            if (!map.containsKey(tmp)) {
                map.put(tmp, String.valueOf(i + 1));
            } else {
                map.put(tmp, map.get(tmp) + "-" + String.valueOf(i + 1));
            }
        }

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = MaxValue;
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int source = input.nextInt();
            int target = input.nextInt();
            matrix[source - 1][target - 1] = 1;
            matrix[target - 1][source - 1] = 1;
        }
        floyd(matrix);
//        Utils.printIntMatrix(matrix);

        //场地
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            //原料
            count = 0;
            for (int j = 1; j <= k; j++) {
                String[] t = map.get(j).split("-");
                min = Integer.MAX_VALUE;
                for (int kk = 0; kk < t.length; kk++) {
                    int tar = Integer.valueOf(t[kk]);
                    min = Math.min(min, matrix[i - 1][tar - 1]);
                }
                count += min;
            }
            System.out.print(count + " ");
        }
    }

    public static void floyd(int[][] matrix) {
        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][m] + matrix[m][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][m] + matrix[m][j];
                    }
                }
            }
        }
    }
}