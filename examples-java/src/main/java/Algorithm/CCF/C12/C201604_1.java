package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/21.
 */
public class C201604_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = input.nextInt();
        }

        int count = 0;
        for (int j = 1; j < n - 1; j++) {
            if ((m[j] > m[j-1] && m[j] > m[j+1]) || (m[j] < m[j-1] && m[j] < m[j+1])) {
                count++;
            }
        }

        System.out.println(count);

    }
}
