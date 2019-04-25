package LeetCode.Easy.E401_500;

/**
 * Given a non-empty array of integers, return the third maximum number
 * in this array. If it does not exist, return the maximum number.
 * Created by liuxiang on 2018/11/12.
 */
public class E414_Third_Maximum_Number {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        int reuslt = thirdMax(nums);
        System.out.println(reuslt);
    }

    public static int thirdMax(int[] nums) {

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second && nums[i] != first) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third  && nums[i] != second && nums[i] != first) {
                third = nums[i];
            }
        }

       return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}
