package LeetCode.Easy.E401_500;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/heaters/
 * Created by liuxiang on 2018/11/21.
 */
public class E475_Heaters {
    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        int result = findRadius(houses, heaters);
        System.out.println(result);
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int redius = 0;
        int i = 0;
        int j = 0;
        while (i < houses.length && j < heaters.length - 1) {
            if (houses[i] >= heaters[j] && houses[i] <= heaters[j + 1]) {
                redius = Math.max(Math.min(Math.abs(houses[i] - heaters[j]),  Math.abs(houses[i] - heaters[j + 1])), redius);
                i++;
                if (houses[i] != heaters[j] && houses[i] != heaters[j + 1]) {
                    j++;
                }
            } else if (houses[i] < heaters[j]) {
                redius = Math.max(Math.abs(houses[i] - heaters[j]), redius);
                i++;
            } else {
                j++;
            }
        }

        while (i < houses.length) {
            redius = Math.max(Math.abs(houses[i] - heaters[j]), redius);
            i++;
        }

        return redius;
    }
}
