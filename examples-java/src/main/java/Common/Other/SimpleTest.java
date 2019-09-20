package Common.Other;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by liuxiang on 2018/8/1.
 */
public class SimpleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        String s = input.next();
        int count = 0;

        if (isUpperCase(s.charAt(0))) {
            count++;
        }

        boolean flag = false;
        for (int i = 1, j = i - 1; i < length; i++, j++) {

            if (!isUpperCase(s.charAt(i)) && isUpperCase(s.charAt(j)) && !flag) {
                count++;
            }

            if (isUpperCase(s.charAt(i)) && !isUpperCase(s.charAt(j)) && !flag) {
                count++;
            }
        }

        System.out.println(count + length);
    }

    public static boolean isUpperCase(char c) {
        return c >= 65 && c <= 90;
    }
}