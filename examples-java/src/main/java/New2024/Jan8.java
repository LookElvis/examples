package New2024;

import java.util.HashMap;
import java.util.Map;

public class Jan8 {

    /**
     * https://leetcode.cn/problems/number-of-boomerangs/submissions/
     * @param args
     */
    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p: points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q: points) {
                int dist = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int value: map.values()){
                ans += value * (value - 1);
            }
        }
        return ans;
    }
}
