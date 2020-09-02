package New.Test18;

import java.util.Scanner;

/**
 *小团正在装饰自己的书桌，他的书桌上从左到右有m个空位需要放上装饰物。商店中每个整数价格的装饰物恰好有一种，且每种装饰物的数量无限多。

 小团去商店的时候，想到了一个购买方案，他要让右边的装饰物价格是左边的倍数。用数学语言来说，假设小团的m个装饰物价格为a1,a2...am，那么对于任意的1≤i≤j≤m，aj是ai的倍数。

 小团是一个节约的人，他希望最贵的装饰物不超过n元。现在，请你计算小团有多少种购买的方案？
 * Created by Elvis on 2020/8/15.
 */
public class demo5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        if (m == 1) {
            System.out.println(n);
        }
        if (m == 2) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j % i == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        if (m == 3) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= n; k++) {
                        if (j % i == 0 && k % i == 0 && k % j == 0) {
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
        if (m == 4) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= n; k++) {
                        for (int kk = 1; kk <= n; kk++) {
                            if (j % i == 0 && k % i == 0 && kk % i == 0 && k % j == 0 && kk % j == 0 && kk % k == 0) {
                                count++;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
