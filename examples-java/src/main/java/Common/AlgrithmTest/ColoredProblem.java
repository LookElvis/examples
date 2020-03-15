package Common.AlgrithmTest;

/**
 * Created by Elvis on 2020/2/29.
 */
public class ColoredProblem {
    public static void main(String[] args) {
        int[][] m = new int[][] {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    count++;
                    change(m, i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void change(int[][] m, int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[i].length || m[i][j] != 1 || m[i][j] == 2) {
            return;
        }
        m[i][j] = 2;
        change(m, i - 1, j);
        change(m, i + 1, j);
        change(m, i, j - 1);
        change(m, i, j + 1);
    }
}
