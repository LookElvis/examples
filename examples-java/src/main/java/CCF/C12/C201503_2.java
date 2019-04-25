package CCF.C12;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/20.
 */
public class C201503_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int t = input.nextInt();
            if (!map.containsKey(t)) {
                map.put(t, 1);
            } else {
                map.put(t, map.get(t) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for(Map.Entry<Integer, Integer> mapping : list){
            System.out.println(mapping.getKey() + " " + mapping.getValue());
        }

    }
}
