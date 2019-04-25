package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/21.
 */
public class C201609_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int max = 0;
        int d = input.nextInt();

        for (int i = 1; i < n; i++) {
            int t = input.nextInt();
            max = Math.abs(t - d) > max ? Math.abs(t - d) : max;
            d = t;
        }

        System.out.print(max);
    }
}
