package LeetCode.Easy.E201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out
 * whether there are two distinct indices i and j in the
 * array such that nums[i] = nums[j] and the absolute
 * difference between i and j is at most k.
 * https://leetcode.com/submissions/detail/185136887/
 * Created by liuxiang on 2018/10/25.
 */
public class E219_Contains_DuplicateII {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,1,2,1};
        int k = 3;
        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (i-map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
