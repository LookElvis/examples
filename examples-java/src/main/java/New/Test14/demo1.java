package New.Test14;

import java.util.Scanner;

/**
 * 猿辅导笔试
 * Created by Elvis on 2020/8/1.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[1000000];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            for (int j = s; j < e; j++) {
                array[j]++;
                max = Math.max(max, array[j]);
            }
        }
        System.out.println(max);
    }
}
