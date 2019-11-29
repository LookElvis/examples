package Algorithm.Sort;

import java.util.Arrays;

/**
 * Created by Elvis on 2019/11/29.
 */
public class M274_H_index {

    public int hIndex(int[] citations) {
        //计数
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < citations.length; i++) {
            count[Math.min(citations[i], n)]++;
        }
        //找最大值
        int k = n;
        for (int s = count[k]; k > s; s += count[k]) {
            k--;
        }
        return k;
    }


    public int hIndex1(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        int i = 0;
        while (i < len && i+1 <= citations[len - i - 1]) {
            i++;
        }
        return i;
    }
}
