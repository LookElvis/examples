package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/22.
 */
public class C201709_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int rest = n;
        int count = 0;

        int a = rest / 50;
        rest = rest % 50;

        int b = rest / 30;
        rest = rest % 30;

        int c = rest / 10;
        count = 7 * a + 4 * b + c;
        System.out.println(count);
    }
}
