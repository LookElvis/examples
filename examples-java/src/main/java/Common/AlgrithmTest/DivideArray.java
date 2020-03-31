package Common.AlgrithmTest;

import PublicClass.Utils;

/**
 * Created by Elvis on 2020/3/31.
 */
public class DivideArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, -3, 5, -6, -2, 7, 8, 2, -1, -6};
        int p;
        boolean isPos = true;
        for (int i = 0; i < arr.length; i++) {
            p = i;
            if (isPos) {
                while (arr[p] < 0) {
                    p++;
                }
            } else {
                while (arr[p] > 0) {
                    p++;
                }
            }
            swap(arr, p, i);
            isPos = !isPos;
        }
        Utils.printIntArrays(arr);
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }
}
