package New.Test3;

import PublicClass.Utils;

import java.util.*;

/**
 * Created by Elvis on 2020/3/5.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int[] matrix = new int[n];
        int[] orMatrix = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        int tmp = 0;
        int maxNum = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            tmp = input.nextInt();
            matrix[i] = tmp;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (map.get(tmp) > max) {
                maxNum = tmp;
                max = map.get(tmp);
            }
        }
//        System.out.println(maxNum + " " + max);

        for (int i = 0; i < n; i++) {
            if ((matrix[i] != maxNum && (matrix[i] | x) == maxNum)) {
                max++;
            }
        }
        System.out.println(max);
    }
}
