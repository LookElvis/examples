package CCF.C12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/24.
 */
public class C201812_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int y = input.nextInt();
        int g = input.nextInt();
        int sum = r + y + g;

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(0, 1);
        map1.put(1, 3);
        map1.put(2, 2);

        int n = input.nextInt();
        int[] m = new int[]{r, g, y};
        long count = 0;
        for (int i = 0; i < n; i++) {
            long k = input.nextInt();
            long t = input.nextInt();

            if (k != 0) {
                int temp = 0;
                if (k == 1) {
                    temp = 0;
                } else if (k == 2) {
                    temp = 2;
                } else if (k == 3){
                    temp = 1;
                }
                t = t - count;
                while (t <= 0) {
                    t = -((-t) % sum);
                    temp = (temp == 2) ? 0 : (temp + 1);
                    k = map1.get(temp);
                    t = t + m[temp];
                }
            }

            if ((k == 0) || (k == 1)) {
                count += t;
            } else if (k == 2) {
                count += (t + r);
            }
        }
        System.out.println(count);
    }
}
