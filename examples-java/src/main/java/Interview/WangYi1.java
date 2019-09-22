package Interview;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/9/21.
 */
public class WangYi1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            long A = input.nextLong();
            long B = input.nextLong();
            long p = input.nextLong();
            long q = input.nextLong();
            long minus = A - B;
            long count = 0;
            while (minus < 0) {
                if (q == 1) {
                    minus += p;
                    count++;
                } else {
                    if (minus + p >= 0) {
                        minus += p;
                        count++;
                    } else {
                        p = p * q;
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}

//2
//1 5 7 2
//3 5 1 2
