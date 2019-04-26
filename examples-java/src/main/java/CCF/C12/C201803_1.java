package CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/24.
 */
public class C201803_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int count = 0;
        int seq = 1;
        boolean isSeq = false;
        while (input.hasNext()) {
            int t = input.nextInt();
            if (t == 0) {
                break;
            } else if (t == 1) {
                count++;
                seq = 1;
                isSeq = false;
            } else {
                if (isSeq) {
                    count += 2 * seq;
                    seq++;
                } else {
                    count += 2;
                    seq++;
                    isSeq = true;
                }
            }
        }

        System.out.println(count);
    }
}
