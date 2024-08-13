package New2024;

import java.util.Arrays;

public class August11 {

    // https://leetcode.cn/problems/uncrossed-lines/description/
    public int dfs1(int[] nums1, int[] nums2, int i, int j, int[][] matrix) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (matrix[i][j] != -1) {
            return matrix[i][j];
        }

        int tmp = 0;
        if (nums1[i] == nums2[j]) {
            tmp = dfs1(nums1, nums2, i-1, j-1, matrix) + 1;
        } else {
            tmp = Math.max(dfs1(nums1, nums2, i-1, j, matrix), dfs1(nums1, nums2, i, j-1, matrix));
        }
        matrix[i][j] = tmp;
        return tmp;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] matrix = new int[m][n];
        for (int[] row :matrix) {
            Arrays.fill(row, -1);
        }
        return dfs1(nums1, nums2, m-1, n-1, matrix);
    }


    // https://leetcode.cn/problems/jump-game-ii/
    public int dfs2(int n, int[] nums, int[] fn) {
        if (n == 0) {
            return 0;
        }

        if (fn[n] != -1) {
            return fn[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (n-i + nums[n-i] >= n) {
                // 可以跳跃过去
                int tmp = dfs2(n-i, nums, fn);
                min = Math.min(min, tmp + 1);
            }
        }
        fn[n] = min;
        return min;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] fn = new int[n];
        Arrays.fill(fn, -1);
        return dfs2(n-1, nums, fn);
    }
}
