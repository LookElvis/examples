package Common.AlgrithmTest;

/**
 * 求最长公共子序列（not only 长度）
 * Created by Elvis on 2020/3/23.
 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        String s1 = "abcdfge";
        String s2 = "abdfg";
        System.out.println(longestString(s1, s2));
    }

    public static String longestString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "";
        }

        int start = 0;
        int maxLen = 0;
        int[][] matrix = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 || j == 0) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        matrix[i][j] = 1;
                    }
                    if (matrix[i][j] > maxLen) {
                        maxLen = matrix[i][j];
                        start = i;
                    }
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    if (matrix[i][j] > maxLen) {
                        maxLen = matrix[i][j];
                        start = i - maxLen + 1;
                    }
                }
            }
        }
        return s1.substring(start, start + maxLen);
    }
}
