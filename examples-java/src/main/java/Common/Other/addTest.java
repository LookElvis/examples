package Common.Other;

import java.util.Arrays;

/**
 * Created by liuxiang on 2019/1/4.
 */
public class addTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int sum = add(array);
        System.out.println(sum);
    }

    public static int add(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        return array[0] + add(Arrays.copyOfRange(array, 1, array.length));
    }
}
