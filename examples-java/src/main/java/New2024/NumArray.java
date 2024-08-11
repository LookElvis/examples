package New2024;

class NumArray {

    public int[] prefix;
    public NumArray(int[] nums) {
        int len = nums.length;
        prefix = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
