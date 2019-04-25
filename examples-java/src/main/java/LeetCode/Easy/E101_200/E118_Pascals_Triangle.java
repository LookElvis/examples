package LeetCode.Easy.E101_200;

import java.util.ArrayList;
import java.util.List;

import static LeetCode.PublicClass.Utils.printDoubleArrays;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * https://leetcode.com/submissions/detail/182375550/
 * Created by liuxiang on 2018/10/13.
 */
public class E118_Pascals_Triangle {
    public static void main(String[] args) {
        int numRows = 10;
        List<List<Integer>> list = generate(numRows);
        printDoubleArrays(list);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        while (count < numRows) {
            List<Integer> line = new ArrayList<>();
            for(int i = 0; i <= count; i++) {
                if(i==0 || i==count) {
                    line.add(1);
                } else {
                    line.add(list.get(count-1).get(i-1) + list.get(count-1).get(i));
                }
            }
            list.add(line);
            count++;
        }
        return list;
    }
}
