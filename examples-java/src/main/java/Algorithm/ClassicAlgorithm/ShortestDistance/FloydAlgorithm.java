package Algorithm.ClassicAlgorithm.ShortestDistance;

import java.util.Scanner;

/**
 * 支持负权，动态规划，多源最短路径，不支持负权环，n³复杂度
 *  输入：
 * 节点数、边数
 * （边起点 边终点 边权值）*边数
 * 源点
 * Created by liuxiang on 2019/4/26.
 */
public class FloydAlgorithm {
    public static int MaxValue = 100000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //顶点数
        int vertex = input.nextInt();
        //边数
        int edge = input.nextInt();

        int[][] matrix = new int[vertex][vertex];
        //初始化邻接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < edge; i++) {
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        //调用算法计算最短路径
        floyd(matrix);
    }

    //非递归实现
    public static void floyd(int[][] matrix) {
        String[][] path = new String[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = i + "->" + j;
             }
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][m] + matrix[m][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][m] + matrix[m][j];
                        String s = path[i][m].split("->")[path[i][m].split("->").length - 1];
                        String t = path[m][j].split("->")[0];
                        path[i][j] = path[i][m] + "->" + path[m][j];
                        if (s.equals(t)) {
                            path[i][j] = path[i][j].replaceFirst(s + "->", "");
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j) {
                    if (matrix[i][j] == MaxValue) {
                        System.out.println(i + "到" + j + "不可达");
                    } else {
                        //对连续重复的进行去重
                        System.out.println(i + "到" + j + "的最短路径为：" + path[i][j] + "，最短距离是：" + matrix[i][j]);
                    }
                }
            }
        }
    }
}

//7 10
//0 1 6
//1 2 5
//0 3 2
//3 1 7
//3 4 5
//1 2 5
//1 5 3
//5 2 3
//5 4 2
//4 6 1