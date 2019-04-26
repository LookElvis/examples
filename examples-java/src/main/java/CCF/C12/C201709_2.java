package CCF.C12;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/22.
 */
public class C201709_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        int[] r = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            r[i] = i + 1;
            map.put(i + 1, i);
        }

        int[][] matrix = new int[2 * K][3];
        for (int i = 0, count = 0; i < K; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            //0是还，1是借，排序升序，先还再借
            matrix[count][0] = 1;
            matrix[count][1] = a;
            matrix[count][2] = b;
            count++;

            matrix[count][0] = 0;
            matrix[count][1] = a;
            matrix[count][2] = b + c;
            count++;
        }

        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix.length - i - 1; j++) {
                if(matrix[j][1] > matrix[j + 1][1]) {
                    int temp1 = matrix[j][0];
                    int temp2 = matrix[j][1];
                    int temp3 = matrix[j][2];

                    matrix[j][0] = matrix[j + 1][0];
                    matrix[j][1] = matrix[j + 1][1];
                    matrix[j][2] = matrix[j + 1][2];

                    matrix[j + 1][0] = temp1;
                    matrix[j + 1][1] = temp2;
                    matrix[j + 1][2] = temp3;
                }
            }
        }

        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix.length - i - 1; j++) {
                if(matrix[j][0] > matrix[j + 1][0]) {
                    int temp1 = matrix[j][0];
                    int temp2 = matrix[j][1];
                    int temp3 = matrix[j][2];

                    matrix[j][0] = matrix[j + 1][0];
                    matrix[j][1] = matrix[j + 1][1];
                    matrix[j][2] = matrix[j + 1][2];

                    matrix[j + 1][0] = temp1;
                    matrix[j + 1][1] = temp2;
                    matrix[j + 1][2] = temp3;
                }
            }
        }

        for(int i = 0; i < matrix.length - 1; i++) {
            for(int j = 0; j < matrix.length - i - 1; j++) {
                if(matrix[j][2] > matrix[j + 1][2]) {
                    int temp1 = matrix[j][0];
                    int temp2 = matrix[j][1];
                    int temp3 = matrix[j][2];

                    matrix[j][0] = matrix[j + 1][0];
                    matrix[j][1] = matrix[j + 1][1];
                    matrix[j][2] = matrix[j + 1][2];

                    matrix[j + 1][0] = temp1;
                    matrix[j + 1][1] = temp2;
                    matrix[j + 1][2] = temp3;
                }
            }
        }

//        for(int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                int index = map.get(matrix[i][1]);
                r[index] = 0;
                set.add(index);
            } else {
                int index = set.iterator().next();
                set.remove(index);
                r[index] = matrix[i][1];
                map.put(r[index], index);
            }

//            for (int ii = 0; ii < r.length; ii++) {
//                System.out.print(r[ii] + " ");
//            }
//            System.out.println();
        }

        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
    }
}
