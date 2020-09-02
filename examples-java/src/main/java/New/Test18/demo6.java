package New.Test18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Elvis on 2020/8/15.
 */
public class demo6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        //记录逆序对数
        int count = 0;
        String[] arr = new String[]{
                "2178 8712",
                "21978 87912",
                "219978 879912",
                "2199978 8799912",
                "21782178 87128712",
                "21999978 87999912"
        };
        if (t >= 2178) {
            count++;
        }
        if (t >= 21978) {
            count++;
        }
        if (t >= 219978) {
            count++;
        }
        if (t >= 2199978) {
            count++;
        }
        if (t >= 21782178) {
            count++;
        }
        if (t >= 21999978) {
            count++;
        }
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public static boolean isNi(int i) {
        int j = 0;
        int tmp = i;
        while (tmp != 0) {
            j += tmp % 10;
            tmp /= 10;
            if (tmp != 0) {
                j *= 10;
            }
        }
        return i * 4 == j;
    }
}
