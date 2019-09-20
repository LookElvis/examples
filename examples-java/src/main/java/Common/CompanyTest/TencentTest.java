package Common.CompanyTest;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/9/1.
 */
public class TencentTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int p = input.nextInt();
        int q = input.nextInt();

        long down = 0;
        long up = 0;
        for (int i = p; i <= n - q; i++) {
            down += C(n, i);
        }

        for (int i = p; i <= n - q; i++) {
            up += (C(n, i) * i);
        }

        System.out.println(down + " " + up);

        long x = 1000000007 / down;
        for (long j = x; ; j++) {
            if (j * down % 1000000007 == up) {
                System.out.println(j);
                break;
            }
        }
    }

    public static long C(int m, int n){
        if (n >= m / 2) {
            n = m - n;
        }
        long up = 1;
        long down = 1;
        int t = n;
        for (int i = 0; i < t; i++) {
            up *= m;
            m--;
        }

        for (int i = 0; i < t; i++) {
            down *= n;
            n--;
        }
        return up / down;
    }
}
