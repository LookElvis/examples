package New.Test9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elvis on 2020/4/12.
 */
public class demo2 {
    /**
     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
     * @param R int整型
     * @param N int整型 N进制
     * @return int整型一维数组
     */
    public int[] GetPowerFactor (int R, int N) {
        List<Integer> list = new ArrayList<>();
        int t = R;
        while (t != 0) {
            t /= N;
            int m = R - N * t;
            if (m == 0 || m == 1) {
                list.add(m);
            } else {
                return new int[]{};
            }
            R = t;
        }
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                res.add(count);
            }
            count++;
        }
        int[] rr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }
}
