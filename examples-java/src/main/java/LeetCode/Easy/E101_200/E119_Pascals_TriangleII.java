package LeetCode.Easy.E101_200;

import java.util.ArrayList;
import java.util.List;

import static LeetCode.PublicClass.Utils.printArrayList;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * https://leetcode.com/submissions/detail/182380458/
 * Created by liuxiang on 2018/10/13.
 */
public class E119_Pascals_TriangleII {
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> list = getRow(rowIndex);
        printArrayList(list);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> line = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(list.get(j-1) + list.get(j));
                }
            }
            list = line;
        }
        return list;
    }
}
