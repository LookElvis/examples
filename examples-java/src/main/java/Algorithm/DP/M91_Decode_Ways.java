package Algorithm.DP;

/**
 * Created by Elvis on 2019/12/5.
 */
public class M91_Decode_Ways {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                dp[i] = (s.charAt(i) >= '1' && s.charAt(i) <= '9') ? 1 : 0;
            } else if (i == 1) {
                int index = Integer.parseInt(s.substring(i - 1, i + 1));
                dp[i] += (index >= 1 && index <= 26 && s.charAt(i - 1) != '0') ? 1 : 0;
                dp[i] += (s.charAt(i) >= '1' && s.charAt(i) <= '9') ? dp[i - 1] : 0;
            } else{
                int index = Integer.parseInt(s.substring(i - 1, i + 1));
                dp[i] += (index >= 1 && index <= 26 && s.charAt(i - 1) != '0') ? dp[i - 2] : 0;
                dp[i] += (s.charAt(i) >= '1' && s.charAt(i) <= '9') ? dp[i - 1] : 0;
            }
        }
        return dp[dp.length - 1];
    }
}
