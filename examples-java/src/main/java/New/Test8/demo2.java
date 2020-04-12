package New.Test8;

import PublicClass.Utils;

import java.util.Scanner;

/**
 * 网易互娱
 * Created by Elvis on 2020/4/11.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());  //边长
        int[][] matrix = new int[n][n];
        //转化，道路.为0，建筑#为-1
//        System.out.println(n);
        for (int i = 0; i < n; i++) {
            char[] t = input.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (t[j] == '.') {
                    matrix[i][j] = 0;
                } else if (t[j] == '#') {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = t[j] - '0';
                }
            }
        }
        //降落点
        int x = input.nextInt();
        int y = input.nextInt();
//        Utils.printIntMatrix(matrix);
        //开始dfs
        System.out.println(dfs(matrix, x, y));
    }

    public static int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == -1) {
            return 0;
        }
        int tmp = matrix[i][j];
        matrix[i][j] = -1;
        return tmp + dfs(matrix, i - 1, j)
                + dfs(matrix, i + 1, j) + dfs(matrix, i, j - 1) + dfs(matrix, i, j + 1);
    }
}
