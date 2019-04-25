package CCF.C3;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/5.
 */
public class C201812 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = input.nextLine();
        }

        int[][] data = new int[n][5];
        for (int i = 0; i < n; i++) {
            String temp = strs[i];
            String[] sA = temp.split("/");
            String[] sB = temp.split("\\.");

            String pre = "";
            String suf = "";
            if (sA.length != 1) {
                pre = sA[0];
                suf = sA[1];
                sB = pre.split("\\.");
            }

            data[i][0] = Integer.parseInt(sB[0]);
            if (sB.length == 2) {
                data[i][1] = Integer.parseInt(sB[1]);
            } else if (sB.length == 3) {
                data[i][1] = Integer.parseInt(sB[1]);
                data[i][2] = Integer.parseInt(sB[2]);
            } else if (sB.length == 4) {
                data[i][1] = Integer.parseInt(sB[1]);
                data[i][2] = Integer.parseInt(sB[2]);
                data[i][3] = Integer.parseInt(sB[3]);
            }

            if (sA.length == 1) {
                data[i][4] = sB.length * 8;
            } else {
                data[i][4] = Integer.parseInt(suf);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j][0] > data[j + 1][0]) {
                    int a = data[j][0];
                    int b = data[j][1];
                    int c = data[j][2];
                    int d = data[j][3];
                    int e = data[j][4];
                    data[j][0] = data[j + 1][0];
                    data[j][1] = data[j + 1][1];
                    data[j][2] = data[j + 1][2];
                    data[j][3] = data[j + 1][3];
                    data[j][4] = data[j + 1][4];
                    data[j + 1][0] = a;
                    data[j + 1][1] = b;
                    data[j + 1][2] = c;
                    data[j + 1][3] = d;
                    data[j + 1][4] = e;
                } else if (data[j][0] == data[j + 1][0]){
                    if (data[j][1] > data[j + 1][1]) {
                        int a = data[j][0];
                        int b = data[j][1];
                        int c = data[j][2];
                        int d = data[j][3];
                        int e = data[j][4];
                        data[j][0] = data[j + 1][0];
                        data[j][1] = data[j + 1][1];
                        data[j][2] = data[j + 1][2];
                        data[j][3] = data[j + 1][3];
                        data[j][4] = data[j + 1][4];
                        data[j + 1][0] = a;
                        data[j + 1][1] = b;
                        data[j + 1][2] = c;
                        data[j + 1][3] = d;
                        data[j + 1][4] = e;
                    } else if (data[j][1] == data[j + 1][1]){
                        if (data[j][2] > data[j + 1][2]) {
                            int a = data[j][0];
                            int b = data[j][1];
                            int c = data[j][2];
                            int d = data[j][3];
                            int e = data[j][4];
                            data[j][0] = data[j + 1][0];
                            data[j][1] = data[j + 1][1];
                            data[j][2] = data[j + 1][2];
                            data[j][3] = data[j + 1][3];
                            data[j][4] = data[j + 1][4];
                            data[j + 1][0] = a;
                            data[j + 1][1] = b;
                            data[j + 1][2] = c;
                            data[j + 1][3] = d;
                            data[j + 1][4] = e;
                        } else if (data[j][2] == data[j + 1][2]){
                            if (data[j][3] > data[j + 1][3]) {
                                int a = data[j][0];
                                int b = data[j][1];
                                int c = data[j][2];
                                int d = data[j][3];
                                int e = data[j][4];
                                data[j][0] = data[j + 1][0];
                                data[j][1] = data[j + 1][1];
                                data[j][2] = data[j + 1][2];
                                data[j][3] = data[j + 1][3];
                                data[j][4] = data[j + 1][4];
                                data[j + 1][0] = a;
                                data[j + 1][1] = b;
                                data[j + 1][2] = c;
                                data[j + 1][3] = d;
                                data[j + 1][4] = e;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j][4] > data[j + 1][4]) {
                    int a = data[j][0];
                    int b = data[j][1];
                    int c = data[j][2];
                    int d = data[j][3];
                    int e = data[j][4];
                    data[j][0] = data[j + 1][0];
                    data[j][1] = data[j + 1][1];
                    data[j][2] = data[j + 1][2];
                    data[j][3] = data[j + 1][3];
                    data[j][4] = data[j + 1][4];
                    data[j + 1][0] = a;
                    data[j + 1][1] = b;
                    data[j + 1][2] = c;
                    data[j + 1][3] = d;
                    data[j + 1][4] = e;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(data[i][0]);
            for (int j = 1; j < 4; j++) {
                System.out.print("." + data[i][j]);
            }
            System.out.println("/" + data[i][4]);
        }
    }
}
