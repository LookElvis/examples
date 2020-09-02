package Common.AlgrithmTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 先按hashmap的value升序，value相同按key升序
 * Created by Elvis on 2020/7/18.
 */
public class SortHashMapByValue {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 8);
        map.put(5, 2);
        map.put(1, 2);
        map.put(4, 1);

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return o1.getValue() - o2.getValue();
                }
            }
        });

        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));


        for (Map.Entry e: list) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
