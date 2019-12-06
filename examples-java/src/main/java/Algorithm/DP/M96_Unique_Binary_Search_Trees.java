package Algorithm.DP;

/**
 * Created by Elvis on 2019/12/6.
 */
public class M96_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        if (n == 0) return 1;
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                count += g[j - 1] * g[i - j];
            }
            g[i] = count;
        }
        return g[n];
    }
}
