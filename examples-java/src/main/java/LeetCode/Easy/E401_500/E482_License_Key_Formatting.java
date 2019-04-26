package LeetCode.Easy.E401_500;

/**
 * https://leetcode.com/problems/license-key-formatting/
 * https://leetcode.com/submissions/detail/191011948/
 * Created by liuxiang on 2018/11/22.
 */
public class E482_License_Key_Formatting {
    public static void main(String[] args) {
        String S = "2-5g-3-J";
        int K = 2;
        String license = licenseKeyFormatting(S, K);
        System.out.println(license);
    }

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        String s = S.replaceAll("-", "");
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() % K != 0) {
            sb.append(s.substring(0, s.length() % K));
            s = s.substring(s.length() % K);
            sb.append("-");
        }

        int index = 0;
        while (index < s.length()) {
            sb.append(s.substring(index, index + K));
            sb.append("-");
            index += K;
        }

        return sb.substring(0, sb.length() - 1).toUpperCase();
    }
}
