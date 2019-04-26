package CCF.C12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liuxiang on 2019/2/19.
 */
public class C201409_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < number; i++) {
            set.add(input.nextInt());
        }

        int count = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int t = it.next();
            if (set.contains(t - 1)) {
                count++;
            }
            if (set.contains(t + 1)) {
                count++;
            }
        }
        System.out.println(count / 2);
    }
}
