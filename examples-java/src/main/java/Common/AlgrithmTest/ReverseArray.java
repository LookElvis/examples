package Common.AlgrithmTest;

import PublicClass.Utils;

/**
 * Created by Elvis on 2020/3/21.
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 6, 2, 8, 22, 15, 7};
        reverse(arr);
        System.out.println("数组翻转：");
        Utils.printIntArrays(arr);
        System.out.println();

        int[] arr1 = new int[] {1, 4, 6, 2, 8, 22, 15, 7};
        int k = 3;
        removeK(arr1, k);
        System.out.println("向右移动" + k + "位：");
        Utils.printIntArrays(arr1);
    }

    public static void removeK(int[] arr, int k) {
        reverseK(arr, 0, arr.length - k);
        reverseK(arr, arr.length - k, arr.length);
        reverseK(arr, 0, arr.length);
    }

    public static void reverseK(int[] arr, int l, int r) {
        for (int i = l, j = r - 1; i < (l + (r - l) / 2); i++, j--) {
            swap(arr, i, j);
        }
    }

    public static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
