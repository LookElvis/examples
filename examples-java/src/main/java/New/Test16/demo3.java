package New.Test16;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 贝壳笔试
 * Created by Elvis on 2020/8/11.
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        Map<Integer, Integer> map = new TreeMap<>((a, b) -> (b - a));

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int res = 0;
                for (int k = i; k <= j; k++) {
//                    System.out.println(res + " " + k + " " + array[k] + " " + (res | array[k]));
                    res = (res | array[k]);
                }
//                System.out.println(i + " " + j + " " + res);
                map.put(res, Math.min(j - i + 1, map.getOrDefault(res, Integer.MAX_VALUE)));
            }
        }
        int t = map.keySet().iterator().next();
        System.out.println(map.get(t));
    }
}
