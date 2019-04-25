package LeetCode.Easy.E401_500;

import java.util.Arrays;

/**
 * Created by liuxiang on 2018/11/18.
 */
public class E455_Assign_Cookies {
    public static void main(String[] args) {
        int[] g = {2,1,3,4,5};
        int[] s = {1,3,2};
        int result = findContentChildren(g, s);
        System.out.println(result);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }

        return count;
    }
}
