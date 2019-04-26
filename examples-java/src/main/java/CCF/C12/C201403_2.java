package CCF.C12;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/18.
 */
public class C201403_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int line = input.nextInt();
        int ask = input.nextInt();
        int[][] matrix = new int[line][4];
        int[] prior = new int[line];

        for (int a = 0, b = line; a < line; a++, b--) {
            prior[a] = b;
        }

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        for (int m = 0; m < ask; m++) {
            int x = input.nextInt();
            int y = input.nextInt();

            int isTrue = 0;
            for (int k = 0; k < prior.length; k++) {
                int l = prior[k] - 1;
                if (x >= matrix[l][0] && x <= matrix[l][2] && y >= matrix[l][1] && y <= matrix[l][3]) {
                    isTrue = 1;
                    System.out.println(l + 1);

                    int temp = prior[k];
                    for (int d = k; d > 0; d--) {
                        prior[d] = prior[d - 1];
                    }
                    prior[0] = temp;
                    break;
                }
            }
            if (isTrue == 0) {
                System.out.println("IGNORED");
            }
        }
    }
}
