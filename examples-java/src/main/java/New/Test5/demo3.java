package New.Test5;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 招商银行
 * Created by Elvis on 2020/3/27.
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int line = input.nextInt();
        while (line > 0) {
            int n = input.nextInt();
            int[] len = new int[n];
            for (int i = 0; i < n; i++) {
                len[i] = input.nextInt();
            }
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = input.nextInt();
            }
            List<Line> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Line(len[i], weight[i]));
            }

            Collections.sort(list, new Comparator<Line>() {
                @Override
                public int compare(Line o1, Line o2) {
                    if (o2.len >= o1.len && o2.weight >= o1.weight) return 1;
                    return -1;
                }
            });

            for (Line t : list) {
                System.out.println(t.len + " " + t.weight);
            }
            line--;
        }
    }
}

//2
//5
//4 9 5 2 2
//1 3 5 1 4
//3
//2 1 2
//2 1 2

