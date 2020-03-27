package New.Test5;

import java.util.Scanner;

/**
 * 招商银行
 * Created by Elvis on 2020/3/27.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int line = input.nextInt();
        while (line > 0) {
            int n = input.nextInt();
            int[] arr = new int[n];
            boolean isPass2 = false;
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
                if (arr[i] >= 2) {
                    count2++;
                } else if (arr[i] == 1) {
                    count1++;
                }
            }

            if (count2 == 0) {
                System.out.println(-1);
            } else {
                System.out.println(count1 + count2 + 1);
            }
            line--;
        }
    }
}
