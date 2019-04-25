package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/19.
 */
public class C201409_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] matrix = new int[100][100];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();
            for (int m = a; m < c; m++) {
                for (int k = b; k < d; k++) {
                    if (matrix[m][k] == 0) {
                        matrix[m][k] = 1;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
