package New.Test7;

import PublicClass.Utils;

import java.util.Scanner;

/**
 * 网易互联网
 * Created by Elvis on 2020/4/7.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //城市个数
        int m = input.nextInt(); //操作个数
        int s = input.nextInt(); //所在城市编号
        int[][] arr = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    arr[i][j] = 1;
//                }
//            }
//        }
        int count = 0;
        int x, y;
        boolean isF = false;
        int[][] in = new int[m][2];
        for (int i = 0; i < m; i++) {
            //输入数据
            in[i][0] = input.nextInt();
            in[i][1] = input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //操作
            x = in[i][0];
            y = in[i][1];
            if (x == 0) { //y封城
                for (int k = 0; k < n; k++) {
                    arr[k][y - 1] = 1;
                    arr[y - 1][k] = 1;
                }
            } else {  //切断路径
                arr[x - 1][y - 1] = 1;
                arr[y - 1][x - 1] = 1;
            }

            //判断s是否封城
            count++;
            if (judge(arr, s)) {
                isF = true;
                break;
            }
        }
//        Utils.printIntMatrix(arr);
        System.out.println(isF ? count : 0);
    }

    public static boolean judge(int[][] arr, int s) {
        for (int i = 0; i < arr.length; i++) {
            if (s - 1 != i && (arr[s - 1][i] == 0 || arr[i][s - 1] == 0)) {
                return false;
            }
        }
        return true;
    }
}

