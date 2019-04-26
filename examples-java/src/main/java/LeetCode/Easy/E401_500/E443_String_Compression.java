package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

/**
 * https://leetcode.com/problems/string-compression/
 * https://leetcode.com/submissions/detail/189848807/
 * Created by liuxiang on 2018/11/16.
 */
public class E443_String_Compression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int result = compress(chars);
        Utils.printCharArrays(chars);
        System.out.println();
        System.out.println(result);
    }

    public static int compress(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        int i = 1;

        if (chars.length == 1) {
            return 1;
        }

        for (; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                count++;
            } else {
                stringBuilder.append(chars[i-1]);
                if (count != 1) {
                    stringBuilder.append(count);
                    count = 1;
                }
            }
        }

        if (count != 1) {
            stringBuilder.append(chars[i-2]);
            stringBuilder.append(count);
        } else {
            stringBuilder.append(chars[i-1]);
        }

        for (int j = 0; j < stringBuilder.length(); j++) {
            chars[j] = stringBuilder.charAt(j);
        }

        return stringBuilder.length();
    }
}
