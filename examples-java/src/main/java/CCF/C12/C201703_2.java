package CCF.C12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/22.
 */
public class C201703_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] m = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m[i] = i + 1;
            map.put(m[i], i);
        }

        int adjust = input.nextInt();
        for (int i = 0; i < adjust; i++) {
            int x = input.nextInt();
            int y = input.nextInt();

            int index = map.get(x);
            if (y >= 0) {
                int temp = m[index];
                int j = 0;
                for (; j < y; j++) {
                    m[index + j] = m[index + j + 1];
                    map.put(m[index + j], index + j);
                }
                m[index + j] = temp;
                map.put(m[index + j], index + j);
            } else {
                y = -y;
                int temp = m[index];
                int j = 0;
                for (; j < y; j++) {
                    m[index - j] = m[index - j - 1];
                    map.put(m[index - j], index - j);
                }
                m[index - j] = temp;
                map.put(m[index - j], index - j);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(m[i] + " ");
        }
    }
}
