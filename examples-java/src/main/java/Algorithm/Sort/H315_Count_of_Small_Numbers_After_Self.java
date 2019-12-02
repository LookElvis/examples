package Algorithm.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elvis on 2019/12/2.
 */
public class H315_Count_of_Small_Numbers_After_Self {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                count += nums[j] < t ? 1 : 0;
            }
            list.add(count);
        }
        return list;
    }
}
