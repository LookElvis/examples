package New.Test2;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Elvis on 2020/2/28.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double count = 1000;
        double num = 10;
        double[] res = new double[n];
        res[0] = num / count;
        for (int i = 1; i < n; i++) {
            double target = res[i - 1];
            double unTarget = 1.0 - target;
            res[i] = target + unTarget * (10.0 / (1000 - i));
        }
        System.out.println(String.format("%.6f", res[n - 1]));
//        if (n > 990) {
//            System.out.println(String.format("%.6f", 1.0));
//        }
    }
}
