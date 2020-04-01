package New.Test6;

import java.util.Scanner;

/**
 * Created by Elvis on 2020/4/1.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//初始海豚数
        int m = input.nextInt();//海豚寿命
        int p = input.nextInt();//海豚生宝宝的年份数
        int[] arr = new int[p]; //海豚生宝宝的年份
        for (int i = 0; i < p; i++) {
            arr[i] = input.nextInt();
        }
        int x = input.nextInt(); //计算第几年后的结果
        int[] born = new int[x + 1];
        int[] dead = new int[x + 1];
        born[0] = n;
        int countBorn = 0;
        int countDeath = 0;
        for (int i = 0; i < born.length; i++) {
            if (born[i] != 0) {
                //出生的海豚
                for (int j = 0; j < arr.length; j++) {
                    if (i + arr[j] < born.length) {
                        born[i + arr[j]] += born[i];
                    }
                }
                //死亡的海豚
                if (i + m + 1 < dead.length) {
                    dead[i + m + 1] += born[i];
                }
            }
            countBorn += born[i];
            countDeath += dead[i];
        }

        System.out.println(countBorn - countDeath);
    }
}
