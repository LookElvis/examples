package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * https://leetcode.com/submissions/detail/190056490/
 * Created by liuxiang on 2018/11/17.
 */
public class E448_Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);
        Utils.printArrayList(list);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }

        for (int j = 1; j <= nums.length; j++) {
            if (!set.contains(j)) {
                list.add(j);
            }
        }

        return list;
    }
}
