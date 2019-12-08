package LeetCode.WeekExam.Week166;

import java.util.*;

/**
 * Created by Elvis on 2019/12/8.
 */
public class M5280 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int t = groupSizes[i];
            if (!map.containsKey(t)) {
                map.put(t, i + "");
            } else {
                map.put(t, map.get(t) + "-" + i);
            }
            System.out.println(map.get(t));
        }

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int num = it.next();
            String value = map.get(num);
            String[] s = value.split("-");
            int[] n = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                n[i] = Integer.parseInt(s[i]);
            }
            List<Integer> tList = new ArrayList<>();
            for (int j = 0; j < n.length; j++) {
                tList.add(n[j]);
                if ((j + 1) % num == 0) {
                    list.add(tList);
                    tList = new ArrayList<>();
                }
            }
        }
        return list;
    }
}
