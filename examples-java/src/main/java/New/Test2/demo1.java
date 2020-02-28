package New.Test2;

import java.util.Scanner;

/**
 * Created by Elvis on 2020/2/28.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        if (n <= 4) {
            System.out.println(1);
            return;
        }
//        1459516411
//        566194214
//        195857222
        long[] m = new long[n];
        m[0] = 1;
        m[1] = 1;
        m[2] = 1;
        m[3] = 1;
        long count = 1;
        for (int i = 4; i < n; i++) {
            count += m[i - 4];
            m[i] = count;
        }
        System.out.println(count);
    }
}
