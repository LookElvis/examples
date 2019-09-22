package LeetCode.Medium;

/**
 * Created by liuxiang on 2019/9/22.
 */
public class M008_String_To_Integer {
    public static void main(String[] args) {
        String str = "  -2147483648";
//        String str = "2147483647";
//        String str = "  91283472332";
        int result = myAtoi(str);
        System.out.println(result);
    }

    public static int myAtoi(String str) {
        if (str == "" || str.length() == 0) {
            return 0;
        }

        int result = 0;
        long testR = 0;
        boolean isBegin = false;
        boolean isRight = false;
        boolean isMax = false;
        int level = 10;
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (!isBegin) {
                if (t == '+') {
                    isRight = true;
                    isBegin = true;
                } else if (t == '-') {
                    isRight = false;
                    isBegin = true;
                } else if (t >= 48 && t <= 57) {
                    result = result * level + Integer.parseInt(String.valueOf(t));
                    testR = testR * level + Integer.parseInt(String.valueOf(t));
                    isRight = true;
                    isBegin = true;
                } else if (t == ' ') {
                    continue;
                } else {
                    break;
                }
            } else {
                if (t < 48 || t > 57) {
                    break;
                }

                result = result * level + Integer.parseInt(String.valueOf(t));
                testR = testR * level + Integer.parseInt(String.valueOf(t));
            }
           if (result != testR) {
                isMax = true;
                break;
           }
        }

        if (!isRight) {
            if (isMax) {
                result = Integer.MIN_VALUE;
            } else {
                result = -result;
            }
        } else {
            if (isMax) {
                result = Integer.MAX_VALUE;
            }
        }

        return result;
    }
}
