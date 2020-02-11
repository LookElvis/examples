package New.Test1;

import java.util.Scanner;

/**
 * Created by Elvis on 2020/2/11.
 */
public class d2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = input.nextInt();
        }
        int count = 0;
        for (int a = 0; a < num; a++) {
            for (int b = a + 1; b < num; b++) {
                for (int c = b + 1; c < num; c++) {
                    count += isRec(arr[a], arr[b], arr[c]) ? 1 : 0;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isRec(int a, int b, int c) {
        if ((a + b > c && Math.abs(a - b) < c) &&
                (a + c > b && Math.abs(a - c) < b) &&
                (b + c > a && Math.abs(b - c) < a)) {
            return true;
        }
        return false;
    }
}
