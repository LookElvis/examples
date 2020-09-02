package New.Test18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Elvis on 2020/8/15.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long t = input.nextLong();
        //记录逆序对数
        int count = 0;
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= t; i++) {
            if (isNi(i)) {
                count++;
                list.add(i);
            }
        }
        System.out.println(count);
        if (count != 0) {
            for (int i = 0; i < list.size(); i++) {
                long tt = list.get(i);
                System.out.println(tt + " " + 4 * tt);
            }
        }
    }

    public static boolean isNi(long i) {
        int j = 0;
        long tmp = i;
        while (tmp != 0) {
            j += tmp % 10;
            tmp /= 10;
            if (tmp != 0) {
                j *= 10;
            }
        }
        return i * 4 == j;
    }
}
