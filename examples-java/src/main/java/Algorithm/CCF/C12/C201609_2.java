package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/21.
 */
public class C201609_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] m = new int[20];
        for (int i = 0; i < m.length; i++) {
            m[i] = 5;
        }

        for (int i = 0; i < n; i++) {
            int t = input.nextInt();

            boolean isTrue = false;
            for (int j = 0; j < m.length; j++) {
                if (t <= m[j]) {
                    isTrue = true;
                    for (int k = 1; k <= t; k++) {
                        System.out.print(5 * j + k + 5 - m[j] + " ");
                    }
                    m[j] = m[j] - t;
                    System.out.println();
                    break;
                }
            }

            if (!isTrue) {
                int s = t;
                for (int j = 0; j < m.length; j++) {
                    if (m[j] > 0) {
                        if (m[j] < s) {
                            for (int k = 1; k <= m[j]; k++) {
                                System.out.print(5 * j + k + 5 - m[j] + " ");
                            }
                            s = s - m[j];
                            m[j] = 0;
                        } else if (m[j] == s) {
                            for (int k = 1; k <= s; k++) {
                                System.out.print(5 * j + k + 5 - m[j] + " ");
                            }
                            m[j] = 0;
                            break;
                        } else {
                            for (int k = 1; k <= s; k++) {
                                System.out.print(5 * j + k + 5 - m[j] + " ");
                            }
                            m[j] = m[j] - s;
                            break;
                        }
                    }
                }
            }
        }
    }
}
