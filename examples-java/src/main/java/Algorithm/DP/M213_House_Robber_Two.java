package Algorithm.DP;

import java.util.Arrays;

/**
 * Created by Elvis on 2019/12/10.
 */
public class M213_House_Robber_Two {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int i = getMax(Arrays.copyOfRange(nums, 0, nums.length - 1));
		int j = getMax(Arrays.copyOfRange(nums, 1, nums.length));
		return Math.max(i, j);

    }

	public int getMax(int[] nums) {
		int pre = 0;
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			int t = Math.max(pre + nums[i], cur);
			pre = cur;
			cur = t;
		}
		return cur;
	}
}
