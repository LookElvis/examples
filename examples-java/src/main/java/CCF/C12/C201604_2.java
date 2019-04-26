package CCF.C12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/21.
 */
public class C201604_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] source = new int[16][10];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                source[i][j] = input.nextInt();
            }
        }
        for (int j = 0; j < 10; j++) {
            source[15][j] = 1;
        }

        int[][] target = new int[4][4];
        List<String> list = new ArrayList<>();
        for (int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                target[m][n] = input.nextInt();
                if (target[m][n] == 1) {
                    list.add(m + "-" + n);
                }
            }
        }

        int col = input.nextInt();
        int line = Integer.MAX_VALUE;
        for (String str : list) {
            int x = Integer.parseInt(str.split("-")[0]);
            int y = Integer.parseInt(str.split("-")[1]);
//            System.out.println("x&y:" + x + " " + y);
//            boolean isTrue = false;
            for (int j = 4; j < 16; j++) {
                if (source[j][y + col - 1] == 1) {
//                    isTrue = true;
                    line = (((j - x - 1) < line) ? (j - x - 1) : line);
                    break;
                }
            }
//            if (!isTrue) {
//                line = 14 - x;
//            }
//            System.out.println("line1:" + line);
        }
//        System.out.println("final:" + line);

        for (int p = line, r = 0; (r < 4) && p < 15; p++, r++) {
            for (int q = col - 1, t = 0; (t < 4) && q < 10; q++, t++) {
                source[p][q] += target[r][t];
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(source[i][j] + " ");
            }
            System.out.println();
        }
    }
}
