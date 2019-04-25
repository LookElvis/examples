package CCF.C3;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/28.
 */
public class C201409 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String t = s.toLowerCase();
        int isOpen = input.nextInt();
        int n = input.nextInt();

        String[] in = new String[n];
        for (int i = 0; i < n; i++) {
            in[i]  = input.next();
        }

        for (int i = 0; i < n; i++) {
            if (isOpen == 0) {
                String gg = in[i].toLowerCase();
                if (gg.contains(t)) {
                    System.out.println(in[i]);
                }
            } else {
                if (in[i].contains(s)) {
                    System.out.println(in[i]);
                }
            }
        }
    }
}
