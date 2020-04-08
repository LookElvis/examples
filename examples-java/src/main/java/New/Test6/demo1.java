package New.Test6;

import java.util.Scanner;

/**
 * 携程
 * Created by Elvis on 2020/4/1.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        int m, n;
        String t;
        int[] count = new int[3600 * 24];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            t = input.nextLine();
            m = Integer.parseInt(t.split(",")[0]);
            n = Integer.parseInt(t.split(",")[1]);
            for (int j = m; j < n; j++) {
                count[j]++;
                res = Math.max(res, count[j]);
            }
        }
        System.out.println(res);
    }
}
