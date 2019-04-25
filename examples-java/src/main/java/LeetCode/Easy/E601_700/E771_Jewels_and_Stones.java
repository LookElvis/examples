package LeetCode.Easy.E601_700;

/**
 * https://leetcode.com/submissions/detail/177052425/
 *
 * Created by liuxiang on 2018/9/19.
 */
public class E771_Jewels_and_Stones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        int result = numJewelsInStones(J, S);
        System.out.println(result);
    }

    public static int numJewelsInStones(String J, String S) {
        char[] jChars = J.toCharArray();
        int[] temp = new int[256];
        int character1 = 0;
        for(int m = 0; m < jChars.length; m ++) {
            character1 = jChars[m];
            temp[character1] = 1;
        }
        char[] sChars = S.toCharArray();
        int count = 0;
        int character2 = 0;
        for (int i = 0; i < sChars.length; i++) {
            character2 = sChars[i];
            if(temp[character2] == 1) {
                count += 1;
            }
        }
        return count;
    }
}
