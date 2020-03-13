package Common.AlgrithmTest;

import PublicClass.Utils;

/**
 * Created by Elvis on 2020/3/13.
 */
public class FinkTopK {
    public static void main(String[] args) {
//        int[] arr = new int[] {1, 3, 7, 8, 12, 18, 23};
        int[] arr = new int[] {1, 12, 23, 8, 3, 18, 7};
        int k = 5;
        int l = 0;
        int r = arr.length - 1;
        int target = l + ((r - l) >> 1);
        int p = partition(arr, l, r, target);
        while (true) {
            System.out.println(arr[target] + " " + p);
            if (p < k - 1) {
                target = p + 1;
            } else if (p > k - 1) {
                target = p - 1;
            } else {
                System.out.println("Finish:" + arr[p]);
                Utils.printIntArrays(arr);
                System.out.println();
                break;
            }
            p = partition(arr, l, r, target);
        }
    }

    public static int partition(int[] arr, int l, int r, int index) {
        int t = arr[index];
        int p1 = l - 1;
        int p2 = r + 1;
        while (l < p2) {
            if (arr[l] < t) {
                swap(arr, l++, ++p1);
            } else if (arr[l] < t){
                swap(arr, l, --p2);
            } else {
                l++;
            }
        }
        return p1 + 1;
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
