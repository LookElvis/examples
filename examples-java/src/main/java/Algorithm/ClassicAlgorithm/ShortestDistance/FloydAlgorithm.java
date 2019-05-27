package Algorithm.ClassicAlgorithm.ShortestDistance;

import java.util.Scanner;

/**
 * 支持负权，动态规划，多源最短路径，不支持负权环，n³复杂度
 *  输入：
 * 节点数、边数
 * （边起点 边终点 边权值）*边数
 * 源点
 * Created by liuxiang on 2019/5/26.
 */
public class FloydAlgorithm {
    public static int MaxValue = 100000;
    public static int[][] path;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入顶点数和边数:");
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

        //初始化路径数组
        path = new int[matrix.length][matrix.length];

        //初始化边权值
        for (int i = 0; i < edge; i++) {
            System.out.println("请输入第" + (i + 1) + "条边与其权值:");
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
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = -1;
             }
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][m] + matrix[m][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][m] + matrix[m][j];
                        //记录经由哪个点到达
                        path[i][j] = m;
                    }
                }
            }
            System.out.println("经由点：" + m);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == MaxValue) {
                        System.out.print("MAX\t");
                    } else {
                        System.out.print(matrix[i][j] + "\t");
                    }
                }
                System.out.println();
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j) {
                    if (matrix[i][j] == MaxValue) {
                        System.out.println(i + "到" + j + "不可达");
                    } else {
                        System.out.print(i + "到" + j + "的最短路径长度是：" + matrix[i][j]);
                        System.out.print("最短路径为：" + i + "->");
                        findPath(i, j);
                        System.out.println(j);
                    }
                }
            }
        }
    }

    //递归寻找路径
    public static void findPath(int i, int j) {
        int m = path[i][j];
        if (m == -1) {
            return;
        }

        findPath(i, m);
        System.out.print(m + "->");
        findPath(m, j);
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