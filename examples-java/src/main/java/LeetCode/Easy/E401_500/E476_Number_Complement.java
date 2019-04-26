package LeetCode.Easy.E401_500;

/**
 * https://leetcode.com/problems/number-complement/submissions/
 * https://leetcode.com/submissions/detail/190893576/
 * Created by liuxiang on 2018/11/21.
 */
public class E476_Number_Complement {
    public static void main(String[] args) {
        int num = 1;
        int result = findComplement(num);
        System.out.println(result);
    }

    public static int findComplement(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        String s = Integer.toBinaryString(num);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i) == '0' ? '1' : '0';
            stringBuilder.append(c);
        }

        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
