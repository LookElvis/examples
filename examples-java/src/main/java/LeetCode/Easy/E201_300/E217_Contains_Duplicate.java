package LeetCode.Easy.E201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * https://leetcode.com/problems/contains-duplicate/solution/
 * Created by liuxiang on 2018/10/24.
 */
public class E217_Contains_Duplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
