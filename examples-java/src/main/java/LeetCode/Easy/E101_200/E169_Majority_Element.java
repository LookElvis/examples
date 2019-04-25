package LeetCode.Easy.E101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * https://leetcode.com/problems/majority-element/solution/
 * Created by liuxiang on 2018/10/18.
 */
public class E169_Majority_Element {
    public static void main(String[] args) {
        int[] nums = {1};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) + 1 > (nums.length/2)) {
                    return nums[i];
                } else {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}
