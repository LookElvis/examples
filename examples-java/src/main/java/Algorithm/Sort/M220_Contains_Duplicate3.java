package Algorithm.Sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Elvis on 2019/11/28.
 */
public class M220_Contains_Duplicate3 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,5,9,1,5,9};
        int k = 2;
        int t = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    public static long getBucket(int num, long interval) {
        return num >= 0 ? num / interval : (num+1) / interval - 1;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        //桶的间隔
        long interval = t + 1;
        for (int i = 0; i < nums.length; i++) {
            //计算当前数字的桶号
            long b = getBucket(nums[i], interval);

            //桶内有元素一定小于k，直接返回true
            if (map.containsKey(b)) {
                return true;
            }
            //查看当前桶的邻近桶，邻近桶最多只有一个元素，否则已返回true
            if (map.containsKey(b-1) && Math.abs(map.get(b-1) - nums[i]) < interval) {
                return true;
            }
            if (map.containsKey(b+1) && Math.abs(map.get(b+1) - nums[i]) < interval) {
                return true;
            }
            //放入桶内
            map.put(b, (long)nums[i]);
            //窗口的下标超出界限，将窗口最前面的元素移除
            if (i >= k) {
                map.remove(getBucket(nums[i-k], interval));
            }
        }
        return false;
    }
}
