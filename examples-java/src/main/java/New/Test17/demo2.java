package New.Test17;

import java.util.Scanner;

/**
 * 阿里笔试
 * Created by Elvis on 2020/8/12.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            long n = input.nextLong();
            long t = n;
            int index = 1;
            while ((t & 1) == 0) {
                t >>= 1;
                index++;
            }
            t = t - 1;
            while (--index > 0) {
                t = (t << 1);
                t += 1;
            }
            System.out.println(t);
        }
    }
}
