package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/20.
 */
public class C201509_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int y = input.nextInt();
        int d = input.nextInt();

        int[] s = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] t = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            for (int i = 0; i < s.length; i++) {
                d -= s[i];
                if (d <= 0) {
                    System.out.println(i + 1);
                    System.out.println(d + s[i]);
                    break;
                }
            }
        } else {
            for (int i = 0; i < t.length; i++) {
                d -= t[i];
                if (d <= 0) {
                    System.out.println(i + 1);
                    System.out.println(d + t[i]);
                    break;
                }
            }
        }
    }
}
