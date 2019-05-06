package ClassicAlgorithm.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 背包问题
 * 输入：
 * 物品数 背包容量
 * （物品价值 物品重量 物品名称）*物品数
 * Created by liuxiang on 2019/4/29.
 */
public class ZeroOnePackAlgorithm {
    public static Map<Integer, String> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int weight = input.nextInt();

        int[][] matrix = new int[n][weight];
        int[][] index = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                index[i][j] = input.nextInt();
            }
            map.put(i, input.next());
        }
        dealBag(index, matrix);
    }

    public static void dealBag(int[][] index, int[][] matrix) {
        int first = -1;
        int second = -1;
        int price = -1;
        String f = "";
        String s = "";

        String[][] name = new String[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) { //3
            for (int j = 0; j < matrix[0].length; j++) {  //4
                first = (i - 1 >= 0) ? matrix[i - 1][j] : 0;
                f = (i - 1 >= 0) ? (name[i - 1][j] + " ") : "";

                price = index[i][0];

                if(i - 1 >= 0) {  //不是第一件物品
                    if (j > index[i][1] - 1) {
                        second = price + matrix[i - 1][j - index[i][1]];
                        s = i + " " + name[i - 1][j - index[i][1]];
                    } else if (j == index[i][1] - 1) {
                        second = price;
                        s = i + " ";
                    } else {
                        second = 0;
                        s = "";
                    }
                } else {   //第一件物品，剩余空间的价值不存在
                    second = (j >= index[i][1] - 1) ? price : 0;
                    s = (j >= index[i][1] - 1) ? i + " " : "";
                }

                matrix[i][j] = first > second ? first : second;
                name[i][j] =  first > second ? f : s;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ":" + name[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("最大价值为：" + matrix[matrix.length - 1][matrix[0].length - 1]);
        System.out.print("包含物品为：");
        String result = name[matrix.length - 1][matrix[0].length - 1];
        for (String t: result.split(" ")) {
            int r = Integer.parseInt(t);
            System.out.print(map.get(r) + " ");
        }

    }
}

//3 4
//1500 1 a
//3000 4 b
//2000 3 c
