package New.Test15;

import java.util.*;

/**
 * 网易严选秋招笔试
 * Created by Elvis on 2020/8/8.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            long t = input.nextLong();
            if (t == 2 || t == 3) {
                cnt++;
            } else if (t > 3) {
                cnt += t / 2;
            }
        }
        System.out.println(cnt);
    }
}
