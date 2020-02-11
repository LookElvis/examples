package Algorithm.ClassicAlgorithm.ShortestDistance;

import java.util.Scanner;

/**
 * 非负权，贪心算法，单源最短路径，n²复杂度，可以用堆进行获取最小值优化
 * 输入：
 * 节点数、边数
 * （边起点 边终点 边权值）*边数
 * Created by liuxiang on 2019/5/26.
 */
public class DijstraAlgorithm {
    //不能设置为Integer.MAX_VALUE，否则两个Integer.MAX_VALUE相加会溢出导致出现负权
    public static int MaxValue = 100000;

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
        for (int i = 0; i < edge; i++) {
            System.out.println("请输入第" + (i + 1) + "条边与其权值:");
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        //单源最短路径，源点
        int source = input.nextInt();
        //调用dijstra算法计算最短路径
        dijstra(matrix, source);
    }

    public static void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

//        System.out.println("shortest0:");
//        for (int i = 0; i < shortest.length; i++) {
//            System.out.print(shortest[i] + " ");
//        }
//        System.out.println();
//        System.out.println("visited0:");
//        for (int i = 0; i < visited.length; i++) {
//            System.out.print(visited[i] + " ");
//        }
//        System.out.println();

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

//            System.out.println("shortest:" + index);
//            for (int t = 0; t < shortest.length; t++) {
//                System.out.print(shortest[t] + " ");
//            }
//            System.out.println();
//            System.out.println("visited:" + index);
//            for (int t = 0; t < visited.length; t++) {
//                System.out.print(visited[t] + " ");
//            }
//            System.out.println();

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;
                }
            }

        }

        //打印最短路径
        for (int i = 0; i < matrix.length; i++) {
            if (i != source) {
                if (shortest[i] == MaxValue) {
                    System.out.println(source + "到" + i + "不可达");
                } else {
                    System.out.println(source + "到" + i + "的最短路径为：" + path[i] + "，最短距离是：" + shortest[i]);
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
//4 5 5
//5 4 2
//4 6 1
//0