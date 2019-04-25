package LeetCode.Easy.E201_300;

/**
 * https://leetcode.com/problems/nim-game/description/
 * https://leetcode.com/problems/nim-game/solution/
 * Created by liuxiang on 2018/11/2.
 */
public class E292_Nim_Game {
    public static void main(String[] args) {
        int n = 5;
        boolean result = canWinNim(n);
        System.out.println(result);
    }

    public static boolean canWinNim(int n) {
        if ((n&3) == 0) {
            return false;
        } else {
            return true;
        }
    }
}
