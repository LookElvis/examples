package LeetCode.Easy.E001_100;

/**
 * Given an array nums and a value val,
 * remove all instances of that value in-place and return the new length.
 * https://leetcode.com/submissions/detail/177453707/
 * Created by liuxiang on 2018/9/21.
 */
public class E027_Remove_Element {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int len = removeElement(nums, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }
}
