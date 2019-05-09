package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/22.
 */
public class C201703_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int count = 0;
        boolean isTrue = true;
        int rest = k;

        for (int i = 0; i < n; i++) {
            int t = input.nextInt();
            rest -= t;
//            System.out.println(rest);
            if (isTrue) {
                count++;
            }

            if (rest > 0) {
                isTrue = false;
            } else {
                rest = k;
                isTrue = true;
            }
        }

        System.out.println(count);
    }
}
