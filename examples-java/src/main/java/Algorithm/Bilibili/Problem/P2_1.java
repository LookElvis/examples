package Algorithm.Bilibili.Problem;

/**
 * 小和问题
 * Created by Elvis on 2019/12/8.
 */
public class P2_1 {
    public static void main(String[] args) {
        int[] array = new int[] {4, 1, 3, 5, 0, 6};
        System.out.println(countSum(array, 0, array.length - 1));
    }

    public static int countSum(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return countSum(array, l, mid) + countSum(array,mid + 1, r)
                + merge(array, l, mid, r);
    }

    public static int merge(int[] array, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int count = 0;
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            count += array[p1] < array[p2] ? (r - p2 + 1) * array[p1] : 0;
            help[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= m) {
            help[i++] = array[p1++];
        }
        while (p2 <= r) {
            help[i++] = array[p2++];
        }
        for (i = 0; i < help.length; i++) {
            array[l + i] = help[i];
        }
        return count;
    }
}
