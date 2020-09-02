package New.Test18;

import java.util.Scanner;

/**
 * Created by Elvis on 2020/8/15.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        boolean isBegin = true;
        String begin = "";
        int count = 0;
        for (int i = 0; i < n; i++) {
            String s = input.nextLine();
            String source = s.split(" ")[0];
            String target = s.split(" ")[1];
            if (isBegin) {
                isBegin = false;
                begin = source;
                continue;
            } else {
                if (target.equals(begin)) {
                    isBegin = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
