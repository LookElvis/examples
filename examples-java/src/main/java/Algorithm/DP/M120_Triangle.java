package Algorithm.DP;

import java.util.List;

/**
 * Created by Elvis on 2019/12/7.
 */
public class M120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int tmp = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    tmp = triangle.get(i-1).get(j);
                } else if (j == i) {
                    tmp = triangle.get(i-1).get(j-1);
                } else {
                    tmp = Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j));
                }
                triangle.get(i).set(j, triangle.get(i).get(j) + tmp);

                if (i == triangle.size() - 1) {
                    min = triangle.get(i).get(j) < min ? triangle.get(i).get(j) : min;
                }
            }
        }
        return min;
    }
}
