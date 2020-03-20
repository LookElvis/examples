package New.Test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Elvis on 2020/3/19.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.next();
        }
        Arrays.sort(strings);
        int[] length = new int[n];
        length[0] = strings[0].length();
        for (int i = 0; i < n; i++) {
            char t1 = strings[i].charAt(0);
            for (int j = 0; j < i; j++) {
                char t2 = strings[j].charAt(strings[j].length() - 1);
//                System.out.println(t1 + " " + t2);
                if (t1 >= t2) {
                    length[i] = Math.max(length[i], strings[i].length() + length[j]);
                }
            }
        }
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < length.length; i++) {
            count = Math.max(count, length[i]);
        }
        System.out.println(count);
    }
}
