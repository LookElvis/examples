package Common.Other;

import PublicClass.Utils;

import java.io.InputStream;
import java.io.InputStreamReader;
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
        Integer a = 321;
        Integer b = 321;
        System.out.println(a == b);
        HashMap<Integer, String> map = new HashMap<>();
        int aa = Integer.parseInt("121", 32);
        System.out.println(aa);
        int bb = Integer.parseInt("221", 32);
        System.out.println(bb);
        int res = aa + bb;
        System.out.println(Integer.toString(res, 32));
        System.out.println(String.format("%.6f", 1 / 3.0));

//        int[] arr = new int[] {1, 3, 5, 6};
//        System.out.println(Arrays.asList(arr).size());
    }
}