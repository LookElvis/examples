package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * https://leetcode.com/submissions/detail/183355992/
 * Created by liuxiang on 2018/10/17.
 */
public class E167_Two_SumII_Input_array_is_sorted {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 13;
        int[] result = twoSum(numbers, target);
        Utils.printIntArrays(result);
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target-numbers[0]) {
                return null;
            }
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i])+1, i+1};
            }
            map.put(target-numbers[i], i);
        }
        return null;
    }
}
