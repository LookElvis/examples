package New.Test16;

import java.util.Scanner;

/**
 * 贝壳笔试
 * Created by Elvis on 2020/8/11.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len = Integer.parseInt(input.nextLine());
        String s = input.nextLine();
        int count = 0;
        for (int l = 0, r = len - 1; l < r; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
