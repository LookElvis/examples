package New.Test15;

import java.util.Scanner;

/**
 * 网易严选秋招笔试
 * Created by Elvis on 2020/8/8.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = input.nextInt();
            cnt += arr[i];
        }
        System.out.println(cnt / 3);
    }
}
