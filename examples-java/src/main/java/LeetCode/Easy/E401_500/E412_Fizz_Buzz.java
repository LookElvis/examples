package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/description/
 * https://leetcode.com/submissions/detail/188812556/
 * Created by liuxiang on 2018/11/11.
 */
public class E412_Fizz_Buzz {
    public static void main(String[] args) {
        int n = 15;
        List<String> list = fizzBuzz(n);
        Utils.printArrayList(list);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        int fizz = 0;
        int buzz = 0;
        for (int i = 1; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                list.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                list.add("Buzz");
                buzz = 0;
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }
}
