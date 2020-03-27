package New.Test5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 招商银行
 * Created by Elvis on 2020/3/27.
 */

/**
 * 招商银行
 * Created by Elvis on 2020/3/27.
 */
public class demo2 {
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

            List<Line> result = list.stream()
                    .sorted(Comparator.comparing(Line::getLen).thenComparing(Line::getWeight))
                    .collect(Collectors.toList());
            int count = 0;
            for (int i = 0; i < n; i++) {
                Line t1 = result.get(i);
                if (t1.flag == 0) {
                    t1.flag = 1;
                    count++;
                    int l = t1.len;
                    int w = t1.weight;

                    for (int j = 0; j < n; j++) {
                        Line t2 = result.get(j);
                        if (t2.flag == 0 && t2.len >= l && t2.weight >= w) {
                            t2.flag = 1;
                            l = t2.len;
                            w = t2.weight;
                        }
                    }
                }
            }
            System.out.println(count);
            line--;
        }
    }
}

class Line {
    public int len;
    public int weight;
    public int flag = 0;
    public Line(int len, int weight) {
        this.len = len;
        this.weight = weight;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

