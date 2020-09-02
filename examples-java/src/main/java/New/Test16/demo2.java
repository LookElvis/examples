package New.Test16;

import java.util.Scanner;

/**
 * 贝壳笔试
 * Created by Elvis on 2020/8/11.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            long m = input.nextLong();
            long n = input.nextLong();
            if (m == 1 && (n % 2) == 1) {
                if ((Math.sqrt(n) * Math.sqrt(n) == n)) {
                    System.out.println((long) Math.sqrt(n));
                } else {
                    System.out.println(n);
                }
            } else if (n == 1 && (m % 2) == 1) {
                if ((Math.sqrt(m) * Math.sqrt(m) == m)) {
                    System.out.println((long) Math.sqrt(m));
                } else {
                    System.out.println(m);
                }
            } else {
                System.out.println(2);
            }
        }
    }
}
