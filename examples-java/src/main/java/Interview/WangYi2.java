package Interview;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/9/21.
 */
public class WangYi2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();


        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int count = 0;
            long[] array = new long[n];
            for (int j = 0; j < n; j++) {
                array[j] = input.nextLong();
            }

            long first = array[0];
            for (int j = 0; j < n - k; ) {
                long max = Integer.MIN_VALUE;
                int index = -1;
                boolean isChange = false;

                for (int m = 1; m <= k; m++) {
                    if (array[j + m] > max && array[j + m] <= first) {
                        max = array[j + m];
                        index = j + m;
                        isChange = true;
                    }
                }
//                System.out.println(max);

                if (!isChange) {
                    count++;
                    long mm = Integer.MIN_VALUE;
                    int ii = -1;
                    for (int m = 1; m <= k; m++) {
                        if (array[j + m] > mm) {
                            mm = array[j + m];
                            ii = j + m;
                        }
                    }
//                    System.out.println(ii + "is");
                    j = ii;
                    first = array[j];
                } else {
//                    System.out.println(index + "no");
                    j = index;
                    first = array[j];
                }
            }

            if (count <= 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

//2
//1 5 7 2
//3 5 1 2
