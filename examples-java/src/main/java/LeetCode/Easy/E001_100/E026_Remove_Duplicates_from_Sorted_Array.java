package LeetCode.Easy.E001_100;

/**
 * Given a sorted array nums,
 * remove the duplicates in-place such that each element appear only once and return the new length.
 * https://leetcode.com/submissions/detail/177432661/
 * Created by liuxiang on 2018/9/21.
 */
public class E026_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[count] = nums[i];
                count += 1;
            }
        }

        return count;
    }
}
