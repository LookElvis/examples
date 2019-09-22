package Interview;

import java.util.*;

/**
 * Created by liuxiang on 2019/9/20.
 */
public class Tencent11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        Set<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(input.nextLong());
        }

        Iterator<Long> it = set.iterator();
        long count = 0;
        for (int i = 0; i < k; i++) {
            if (!it.hasNext()) {
                System.out.println(0);
                continue;
            }
            long t = it.next();
            t = t - count;
            count += t;
            if (t <= 0) {
                System.out.println(0);
            } else {
                System.out.println(t);
            }
        }
    }
}

//7 6
//5 8 10 3 6 10 8
