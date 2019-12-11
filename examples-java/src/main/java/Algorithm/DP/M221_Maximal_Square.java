package Algorithm.DP;

/**
 * Created by Elvis on 2019/12/11.
 */
public class M221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] count = new int[matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            count[i] = matrix[0][i] == '1' ? 1 : 0;
            max = matrix[0][i] == '1' ? 1 : max;
        }

        for (int i = 1; i < matrix.length; i++) {
            int pre = 0;
            int tmp = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    pre = count[0];
                    count[0] = matrix[i][0] == '1' ? 1 : 0;
                    max = Math.max(max, count[0]);
                    max = Math.max(max, tmp);
                } else {
                    if (matrix[i][j] == '0') {
                        pre = count[j];
                        count[j] = 0;
                    } else {
                        tmp = Math.min(count[j], count[j - 1]);
                        tmp = Math.min(tmp, pre);
                        pre = count[j];
                        count[j] = tmp + 1;
                        //System.out.println(count[j] + " " + max);
                        max = Math.max(count[j], max);
                        //System.out.println(max + " max------");
                    }
                }
            }
            //for (int k : count) System.out.print(k + " ");
            //System.out.println();
        }
        return max * max;
    }
}
