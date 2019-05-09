package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/20.
 */
public class C201512_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int add = 0;
        while (n != 0){
            add += n % 10;
            n /= 10;
        }
        System.out.println(add);
    }
}
