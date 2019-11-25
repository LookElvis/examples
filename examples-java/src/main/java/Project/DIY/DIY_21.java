package Project.DIY;

import java.util.*;

/**
 * Created by liuxiang on 2019/11/13.
 */
public class DIY_21 {
    public static void main(String[] args) {
        String[] strings = new String[] {"ab", "ba", "cc", "dd", "ad", "ca"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        String a = new String("aa");
        String b = new String("aa");
        System.out.println(a.compareTo(b));
        System.out.println(a==b);

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

//        List<String> list = new ArrayList<>();
//        list.add("a");
    }
}
