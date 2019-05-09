package Algorithm.CCF.C12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liuxiang on 2019/2/18.
 */
public class C201403_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;

        Set<Integer> set = new HashSet<>();
        while (n > 0) {
            int i = input.nextInt();
            if (set.contains(-i)) {
                set.remove(-i);
                count++;
            } else {
                set.add(i);
            }
            n--;
        }

        System.out.println(count);
    }
}
