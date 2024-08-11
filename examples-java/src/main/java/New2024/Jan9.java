package New2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Jan9 {
    public static void main(String[] args) {

    }

    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        Set<String> dictionarySet = new HashSet<>();
        for (String dic: dictionary) {
            dictionarySet.add(dic);
        }
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = 1; j <= i; j++) {
                if (dictionarySet.contains(s.substring(j - 1, i))) {
                    dp[i] = Math.min(dp[j - 1], dp[i]);
                }
            }
        }
        return dp[s.length()];
    }
}
