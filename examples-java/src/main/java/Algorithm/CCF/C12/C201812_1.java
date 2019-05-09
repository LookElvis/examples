package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/24.
 */
public class C201812_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int y = input.nextInt();
        int g = input.nextInt();

        int n = input.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int k = input.nextInt();
            int t = input.nextInt();
            if ((k == 0) || (k == 1)) {
                count += t;
            } else if (k == 2) {
                count += (t + r);
            }
        }
        System.out.println(count);
    }
}
