package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/20.
 */
public class C201509_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int temp = input.nextInt();
        int count = 1;
        for (int i = 1; i < n; i++) {
            int t = input.nextInt();
            if (t != temp) {
                count++;
            }
            temp = t;
        }
        System.out.print(count);
    }
}
