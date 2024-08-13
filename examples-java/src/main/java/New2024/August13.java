package New2024;

// https://leetcode.cn/problems/implement-magic-dictionary/description/
public class August13 {
    public boolean isArraySpecial(int[] nums) {
        int flag = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == flag) {
                return false;
            } else {
                flag = nums[i] % 2;
            }
        }
        return true;
    }
}
