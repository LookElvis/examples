package Algorithm.CCF.C3;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/27.
 */
public class C201312 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int max = Integer.MIN_VALUE;
        int[] m = new int[n];

        for (int i = 0; i < n; i++) {
            m[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int length = 0;
            for (int j = 0; j < n; j++) {
                if (m[j] >= m[i]) {
                    length++;
                } else {
                    length = 0;
                }
                max = (m[i] * length > max) ?  m[i] * length : max;
            }
        }
        System.out.println(max);
    }
}
