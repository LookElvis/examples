package LeetCode.WeekExam.Week165;

/**
 * Created by liuxiang on 2019/11/24.
 */
public class E1270 {
    public String tictactoe(int[][] moves) {
        int[][] x = new int[3][3];
        int[][] o = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                x[moves[i][0]][moves[i][1]]++;
                if (isWin(x)) {
                    return "A";
                }
            } else {
                o[moves[i][0]][moves[i][1]]++;
                if (isWin(o)) {
                    return "B";
                }
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public boolean isWin(int[][] moves) {
        for (int i = 0; i < 3; i++) {
            if (moves[i][0] == 1 && moves[i][1] == 1 && moves[i][2] == 1) {
                return true;
            }
            if (moves[0][i] == 1 && moves[1][i] == 1 && moves[2][i] == 1) {
                return true;
            }
        }
        if (moves[0][0] == 1 && moves[1][1] == 1 && moves[2][2] == 1) {
            return true;
        }
        if (moves[0][2] == 1 && moves[1][1] == 1 && moves[2][0] == 1) {
            return true;
        }

        return false;
    }
}
