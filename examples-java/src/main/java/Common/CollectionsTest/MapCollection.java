package Common.CollectionsTest;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liuxiang on 2019/4/23.
 */
public class MapCollection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();

            //row
            if (x1 == x2) {
                if (y1 > y2) {
                    int swap = y1;
                    y1 = y2;
                    y2 = swap;
                }
                for (int t = y1; t <= y2; t++) {
                    String temp = x1 + "-" + t;
                    if (!set.contains(temp)) {
                        set.add(temp);
                        count++;
                    }
                }
            } else if (y1 == y2){  //col
                if (x1 > x2) {
                    int swap = x1;
                    x1 = x2;
                    x2= swap;
                }
                for (int t = x1; t <= x2; t++) {
                    String temp = t + "-" + y1;
                    if (!set.contains(temp)) {
                        set.add(temp);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}