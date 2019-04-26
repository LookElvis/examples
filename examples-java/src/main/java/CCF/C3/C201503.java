package CCF.C3;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/1.
 */
public class C201503 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int y1 = input.nextInt();
        int y2 = input.nextInt();

        //闰年
        int[] r1 = new int[] {31, 29, 31, 30, 31, 30, 31, 31 ,30, 31, 30, 31};
        int t1 = 366 % 7;
        //平年
        int[] r2 = new int[] {31, 28, 31, 30, 31, 30, 31, 31 ,30, 31, 30, 31};
        int t2 = 365 % 7;

        for (int i = y1; i <= y2; i++) {
            int count = 0;
            for (int k = 1850; k < i; k++) {
                int add = isRight(k) ? t1 : t2;
                count += add;
            }

            for (int j = 0; j < a - 1; j++) {
                int aa = isRight(i) ? r1[j] : r2[j];
                count = count + aa;
            }
//            count = (count % 7 + 2) % 7;
            count = (count + 1) % 7 + 1;

            int day = 0;
            if (c < count) {
                day = b * 7 + c - count + 1;
            } else {
                day = (b - 1) * 7 + c - count + 1;
            }

            //超过该月天数,该天并不存在
            int bb = isRight(i) ? r1[a - 1] : r2[a - 1];
            if (day > bb) {
                System.out.println("none");
            } else {
                System.out.println(i + "/" + changeFormat(a) + "/" + changeFormat(day));
            }
        }
    }

    public static boolean isRight (int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static String changeFormat(int month) {
        return month < 10 ? ("0" + month) : (month + "");
    }
}
