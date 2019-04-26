package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/25.
 */
public class C201809_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[][] m1 = new int[n][2];
        for (int i = 0; i < n; i++) {
            m1[i][0] = input.nextInt();
            m1[i][1] = input.nextInt();
        }

        int[][] m2 = new int[n][2];
        for (int i = 0; i < n; i++) {
            m2[i][0] = input.nextInt();
            m2[i][1] = input.nextInt();
        }

        int max = m1[n - 1][1] > m2[n - 1][1] ? m1[n - 1][1] : m2[n - 1][1];
        int[] m = new int[max];
        for (int i = 0; i < n; i++) {
            for (int j = m1[i][0]; j < m1[i][1]; j++) {
                m[j - 1] = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = m2[i][0]; j < m2[i][1]; j++) {
                if (m[j - 1] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
