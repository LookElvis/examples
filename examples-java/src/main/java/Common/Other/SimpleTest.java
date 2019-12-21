package Common.Other;

import LeetCode.PublicClass.Utils;

import java.util.*;

/**
 * Created by liuxiang on 2018/8/1.
 */
public class SimpleTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(2);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        Utils.printArrayList(list);
    }
}