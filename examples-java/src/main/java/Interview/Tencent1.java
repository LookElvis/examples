package Interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/9/20.
 */
public class Tencent1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextLong();
        }

        Arrays.sort(array);

        long count = 0;
        for (int i = 0, j = 0; i < k; j++) {
            if (j > n - 1) {
                i++;
                System.out.println(0);
                continue;
            }
            long t = array[j];
            t = t - count;
            count += t;
            if (t <= 0) {
                if (j == n - 1) {
                    i++;
                    System.out.println(0);
                } else {
                    j++;
                }
            } else {
                i++;
                System.out.println(t);
            }
        }
    }
}

//7 6
//5 8 10 3 6 10 8
