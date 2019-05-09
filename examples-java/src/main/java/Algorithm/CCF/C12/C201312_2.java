package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/18.
 */
public class C201312_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String x = input.nextLine();

        String s = x.replaceAll("-", "");
        int[] index = new int[9];
        int n = 1;
        int result = 0;
        for (int i = 0; i < 9; i++) {
            index[i] = Integer.parseInt(s.charAt(i) + "");
            result += index[i] * n;
            n++;
        }

        result = result % 11;
        String re = "";
        if (result == 10) {
            re = "X";
        } else {
            re = result + "";
        }

        if (re.equals(s.charAt(9) + "")) {
            System.out.println("Right");
        } else {
            System.out.println(x.substring(0, x.length() - 1) + re);
        }

    }
}
