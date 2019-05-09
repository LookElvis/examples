package Algorithm.CCF.C3;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/11.
 */
public class C201604 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int P = Integer.parseInt(input.nextLine());

        String now = input.nextLine();
        String[] lines = new String[P];
        for (int i = 0; i < P; i++) {
            lines[i] = input.nextLine();
        }

        for (int i = 0; i < P; i++) {
            String t = lines[i];

            if (t.equals("")) {
                System.out.println(now);
                continue;
            }

            //相对目录
            if (t.charAt(0) != '/') {
                t = now + "/" + t;
            }

            String[] tt = t.split("/");
            String[] rr = new String[tt.length];
            for (int j = 0, e = 0; j < tt.length; j++, e++) {
                if (tt[j].equals(".") || tt[j].equals("/") || tt[j].equals("")) {
                    e--;
                } else if (tt[j].equals("..")){
                    if (e >= 1) {
                        e = e - 2;
                    } else {
                        e--;
                    }
                } else {
                    rr[e] = tt[j];
                }
            }

            int count = 0;
            String re = "";
            for (int m = 0; m < rr.length; m++) {
                if (rr[m] != null) {
                    count++;
                    re = re + "/" + rr[m];
                }
            }
            if (count == 0) {
                re = "/";
            }
            System.out.println(re);
        }
    }
}
