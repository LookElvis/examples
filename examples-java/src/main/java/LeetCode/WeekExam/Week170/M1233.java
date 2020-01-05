package LeetCode.WeekExam.Week170;

/**
 * Created by Elvis on 2020/1/5.
 */
public class M1233 {
    public static void main(String[] args) {

    }
    
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int m = queries[i][0];
            int n = queries[i][1];
            for (int j = m; j <= n; j++) {
                res[i] ^= arr[j];
            }
        }
        return res;
    }
}
