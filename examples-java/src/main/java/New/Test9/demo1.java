package New.Test9;

import java.util.Scanner;

/**
 * 快手
 * Created by Elvis on 2020/4/12.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int res = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                count++;
                left++;
            } else if (chars[i] == ')') {
                right++;
                if (count > 0) {
                    count--;
                    res++;
                }
            }
        }
        left -= res;
        right -= res;
        System.out.println(res + " " + left + " " + right);
    }
}
