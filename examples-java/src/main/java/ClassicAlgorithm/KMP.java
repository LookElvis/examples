package ClassicAlgorithm;

/**
 * 字符串匹配，查找t在s中的位置
 * Created by liuxiang on 2019/1/7.
 */
public class KMP {
    public static void main(String[] args) {
        String s = "ABABCDfeABABACAEAGGFCAB";
        String t = "ABABACA";
        int result = KMP(s, t);
        System.out.println(result);

    }

    public static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();

        int i = 0;
        int j = 0;
        int[] next = getNext(ps);

        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String s) {
        char[] chars = s.toCharArray();
        int[] next = new int[s.length()];
        next[0] = -1;
        int j = 0;
        int k = -1;

        while (j < chars.length - 1) {
            if (k == -1 || chars[j] == chars[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
