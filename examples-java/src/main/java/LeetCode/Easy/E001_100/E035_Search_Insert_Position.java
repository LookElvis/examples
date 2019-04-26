package LeetCode.Easy.E001_100;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * https://leetcode.com/submissions/detail/177486097/
 * Created by liuxiang on 2018/9/21.
 */
public class E035_Search_Insert_Position {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 8;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return i;
    }
}