package Algorithm.CCF.C12;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/18.
 */
public class C201312_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine());
        String temp = input.nextLine();
        String[] x = temp.split(" ");
        int[] y = new int[count];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            y[i] = Integer.parseInt(x[i]);
            if (!map.containsKey(y[i])) {
                map.put(y[i], 1);
            } else {
                map.put(y[i], map.get(y[i]) + 1);
            }
        }

        Set<Integer> set = map.keySet();
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (Integer i : set) {
            if (map.get(i) == max) {
                result = i < result ? i : result;
            } else if (map.get(i) > max) {
                max = map.get(i);
                result = i;
            }
        }

        System.out.println(result);
    }
}
