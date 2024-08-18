package New2024;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic/description/
public class August17 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {

        Map<String, Integer> periodCount = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        // 计算有多少相同的k长度字符串
        for (int i = 0; i < word.length(); i = i+ k) {
            String tmpString = word.substring(i, i + k);
            int tmpCount = periodCount.getOrDefault(tmpString, 0) + 1;
            periodCount.put(tmpString, tmpCount);
            maxCount = Math.max(maxCount, tmpCount);
        }
        return word.length() / k - maxCount;
    }
}
