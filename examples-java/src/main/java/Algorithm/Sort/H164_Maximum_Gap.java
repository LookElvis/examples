package Algorithm.Sort;

import LeetCode.PublicClass.Utils;

import java.util.Arrays;

/**
 * Created by Elvis on 2019/11/27.
 */
public class H164_Maximum_Gap {
    public static void main(String[] args) {
        int nums[] = {4, 3, 7, 8, 15, 13, 6};
        int result = maximumGap(nums);
        System.out.println(result);
    }

    public static int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        //计算全局最大值和最小值
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (max == min) {
            return 0;
        }
        int bucketsNum = nums.length - 1;
        int interval = (int) (Math.ceil((double) (max - min) / bucketsNum));
        int[] bucketsMin = new int[bucketsNum];
        int[] bucketsMax = new int[bucketsNum];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min || nums[i] == max) {
                continue;
            }
            //当前数字的桶号
            int b = (nums[i] - min) / interval;
            bucketsMin[b] = Math.min(bucketsMin[b], nums[i]);
            bucketsMax[b] = Math.max(bucketsMax[b], nums[i]);
        }

        int maxGap = Integer.MIN_VALUE;
        int pre = min;
        for (int i = 0; i < bucketsNum; i++) {
            //直接跳过空桶
            if (bucketsMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMin[i] - pre);
            pre = bucketsMax[i];
        }

        //最大值在边界
        maxGap = Math.max(max - pre, maxGap);
        return maxGap;
    }

    public int maximumGap1(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - pre);
            pre = nums[i];
        }

        return max;
    }
}
