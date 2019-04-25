package LeetCode.Easy.E401_500;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 * https://leetcode.com/submissions/detail/190050451/
 * Created by liuxiang on 2018/11/17.
 */
public class E447_Number_of_Boomerangs {
    public static void main(String[] args) {
//        int[][] points = {{3,4},{-4,-3},{0,0},{5,0}};
//        int[][] points = {{0,0},{1,0},{2,0},{2,4},{3,4},{-1,0},{1,1}};
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int result = numberOfBoomerangs(points);
        System.out.println(result);
    }

    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int temp = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                        + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);

                if (!map.containsKey(temp)) {
                    map.put(temp, 1);
                } else {
                    map.put(temp, map.get(temp) + 1);
                }
            }

            for (Integer m : map.values()) {
                if (m >= 2) {
                    count += m * (m - 1);
                }
            }
            map.clear();
        }

        return count;
    }
}
