package Algorithm.CCF.C12;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/21.
 */
public class C201612_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = input.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int min = 0;
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (m[i] < m[j]) {
                    max++;
                } else if (m[i] > m[j]) {
                    min++;
                }
            }
            if (max == min) {
                set.add(m[i]);
            }
        }

        if (set.size() == 1) {
            System.out.println(set.iterator().next());
        } else {
            System.out.println(-1);
        }
    }
}
