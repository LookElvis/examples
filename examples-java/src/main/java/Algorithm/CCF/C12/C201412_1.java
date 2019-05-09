package Algorithm.CCF.C12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/19.
 */
public class C201412_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int t = input.nextInt();
            if (!map.containsKey(t)) {
                map.put(t, 1);
            } else {
                map.put(t, map.get(t) + 1);
            }
            result[i] = map.get(t);
        }

        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j] + " ");
        }
    }
}
