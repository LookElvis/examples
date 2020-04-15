package New.Test10;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Elvis on 2020/4/15.
 */
public class demo2 {
    public static int [][] forward = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    static class Node{
        int node_x;
        int node_y;
        Node(int x, int y){
            node_x = x;
            node_y = y;
        }
    }
    //  使用广度优先搜索的方法
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        reader.nextLine();
        char[][] strChar = new char[n][m];

        int end_x = -1;
        int end_y = -1;
        LinkedList<Node> queue = new LinkedList<>();

        int[][][] dp = new int[n][m][6];  //  代dp[i][j][k]代表到达[i][j]位置，用了k个飞行器时（不一定要都用，是有k个飞行器的条件），最少经过的步数

        //  给dp中的每个值附一个初值
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                for(int k = 0; k < 6;k++){
                    dp[i][j][k] = m * n + 1;  //  注意，不可以赋值为Integer.MAX_VALUE,加减之后会出现负值
                }
            }
        }

        for(int i = 0; i < n; i++){
            String temp = reader.nextLine();
            for(int j = 0; j < m;j++){
                if(temp.charAt(j) == 'S'){
                    Node node = new Node(i,j);
                    for(int k = 0; k < 6;k++){
                        dp[i][j][k] = 0;
                    }
                    queue.add(node);
                }
                else if(temp.charAt(j) == 'E'){
                    end_x = i;
                    end_y = j;
                }
                strChar[i][j] = temp.charAt(j);
            }
        }

        //  广度优先搜索，寻找到达终点经过的最少的步数
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.node_x;
            int y = node.node_y;
            //  上下左右走，相同k更新
            for(int i = 0; i < 4;i++){
                int temp_x = x + forward[i][0];
                int temp_y = y + forward[i][1];
                if(temp_x >= 0 && temp_x < n && temp_y >= 0 && temp_y < m && strChar[temp_x][temp_y] != '#'){
                    boolean flag = false;
                    for(int k = 0; k < 6;k++){
                        if(dp[temp_x][temp_y][k] > dp[x][y][k] + 1){
                            dp[temp_x][temp_y][k] = dp[x][y][k] + 1;
                            flag = true;
                        }
                    }
                    //  相当于每一个节点的步数重新做了更新，都要重新考虑一遍此节点
                    if(flag){
                        queue.add(new Node(temp_x,temp_y));
                    }
                }
            }
            //  跳跃更新
            if(strChar[n - x - 1][m - y - 1] != '#'){

                boolean flag = false;
                for(int k = 0; k < 5; k++){
                    if(dp[n - x - 1][m - y - 1][k + 1] > dp[x][y][k] + 1){
                        dp[n - x - 1][m - y - 1][k + 1] = dp[x][y][k] + 1;
                        flag = true;
                    }
                }
                if(flag){
                    queue.add(new Node(n - x - 1,n - y - 1));
                }
            }

        }
        if(dp[end_x][end_y][5] != n * m + 1) {
            System.out.println(dp[end_x][end_y][5]);
        }
        else{
            System.out.println(-1);
        }
    }
}
