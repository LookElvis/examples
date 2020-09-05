package New.Test19;

import PublicClass.Utils;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 网易互娱
 * Created by Elvis on 2020/9/5.
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 多少组测试数据
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            // 多少步
            int steps = input.nextInt();
            // 开始点
            int startX = steps, startY = steps;
            // 当前点
            int curX = startX, curY = startY;
            // 结束点
            int endX = -1, endY = -1;
            // 路径矩阵
            int[][] matrix = new int[2 * steps + 1][2 * steps + 1];
            matrix[startX][startY] = 1;
            // bfs最短步数
            int minSteps = 0;

            for (int j = 0; j < steps; j++) {
                int dir = input.nextInt();
                int res = input.nextInt();
                // 结果为1才标记有效路径
                if (res == 1) {
                    // 看方向
                    if (dir == 0) {
                        curX--;
                        matrix[curX][curY] = 1;
                    } else if (dir == 1) {
                        curX++;
                        matrix[curX][curY] = 1;
                    } else if (dir == 2) {
                        curY--;
                        matrix[curX][curY] = 1;
                    } else if (dir == 3) {
                        curY++;
                        matrix[curX][curY] = 1;
                    }
                }
                // 结束点
                if (j == steps - 1) {
                    endX = curX;
                    endY = curY;
                }
            }
            Utils.printIntMatrix(matrix);
            System.out.println(startX + " " + startY);
            System.out.println(endX + " " + endY);
            System.out.println("--------");
            minSteps = bfs(startX, startY, endX, endY, matrix);
            System.out.println(minSteps);
        }
    }

    public static int bfs(int startX, int startY, int endX, int endY, int[][] matrix) {
        int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(startX, startY, 0);
        queue.offer(start);
        int res = 0;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (tmp.x == endX && tmp.y == endY) {
                res = tmp.level;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int x = tmp.x + next[i][0];
                int y = tmp.y + next[i][1];
                if (x < 0 || y < 0 || x > matrix[0].length - 1 || y > matrix.length - 1 || matrix[x][y] == 0) {
                    continue;
                }
                matrix[x][y] = 0;
                queue.offer(new Node(x, y, tmp.level + 1));
            }
        }
        return res;
    }
}

class Node {
    int x;
    int y;
    int level;
    public Node(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}
