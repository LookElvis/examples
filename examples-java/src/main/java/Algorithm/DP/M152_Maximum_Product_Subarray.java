package Algorithm.DP;

/**
 * Created by Elvis on 2019/12/9.
 */
public class M152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = imax;
                imax = imin;
                imin = t;
            }
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);
            max = Math.max(imax, max);
        }
        return max;
    }
}
