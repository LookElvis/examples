package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/24.
 */
public class C201809_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
           m[i] = input.nextInt();
        }

        int[] mm = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                mm[i] = (m[i] + m[i + 1]) / 2;
            } else if (i == (n - 1)) {
                mm[i] = (m[i] + m[i - 1]) / 2;
            } else {
                mm[i] = (m[i - 1] + m[i] + m[i + 1]) / 3;
            }
            System.out.print(mm[i] + " ");
        }
    }
}
