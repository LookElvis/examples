package New.Test8;

import PublicClass.Utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 网易互娱
 * Created by Elvis on 2020/4/11.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();  //用户数
        int[][] newUsers = new int[n][n];  //新->老
        int[][] oldUsers = new int[n][n];  //老->新
        //初始化
        for (int i = 0; i < n; i++) {
            int t1 = input.nextInt();
            for (int j = 0; j < n; j++) {
                int t2 = input.nextInt();
                newUsers[t1 - 1][j] = t2 - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int t1 = input.nextInt();
            for (int j = 0; j < n; j++) {
                int t2 = input.nextInt();
                oldUsers[t1 - 1][j] = t2 - 1;
            }
        }
//        Utils.printIntMatrix(newUsers);
//        Utils.printIntMatrix(oldUsers);
        int[] res = new int[n];
        //记录已被分配的old
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!set.contains(newUsers[i][j])) {
                    res[i] = newUsers[i][j];
                    set.add(newUsers[i][j]);
                    break;
                }

            }
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(i+1 + " " + (res[i] + 1) + " ");
        }
    }
}
