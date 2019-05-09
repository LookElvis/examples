package Algorithm.CCF.C12;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/22.
 */
public class C201712_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int min = Integer.MAX_VALUE;

        int[] m = new int[n];
        for (int i = 0; i < n; i++){
            m[i] = input.nextInt();
        }
        Arrays.sort(m);

        for (int i = 1; i < n; i++) {
            min = Math.abs(m[i] - m[i - 1]) < min ? Math.abs(m[i] - m[i - 1]) : min;
        }

        System.out.println(min);
    }
}
