package LeetCode.Easy.E101_200;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * https://leetcode.com/problems/single-number/solution/
 * Created by liuxiang on 2018/10/15.
 */
public class E136_Single_Number {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    //用异或操作时间复杂度为n、空间复杂度为1
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }
}
