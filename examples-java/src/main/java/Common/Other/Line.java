package Common.Other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/16.
 */
public class Line {
    static int n;
    static int m;
    static int[] matrix;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstLine = input.nextLine();
        n = Integer.parseInt(firstLine.split(" ")[0]);
        m = Integer.parseInt(firstLine.split(" ")[1]);

        matrix = new int[n];
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            matrix[i] = input.nextInt();
            sum += matrix[i];
        }

        double l = 0.0;
        double r = sum / m;
        double mid;
        double max = 1e-8;
        while (Math.abs(l - r) > max) {
            mid = (l + r) / 2;
            if (go(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(String.format("%.2f", l));
    }

    public static boolean go(double s) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (int) (matrix[i] / s);
        }
        if (cnt >= m) {
            return true;
        } else {
            return false;
        }
    }
}
