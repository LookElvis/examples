package New.Test9;

/**
 * Created by Elvis on 2020/4/12.
 */
public class demo3 {
    /**
     * 根据顾客属性计算出顾客排队顺序
     * @param a int整型一维数组 顾客a属性
     * @param b int整型一维数组 顾客b属性
     * @return int整型一维数组
     */
    public int[] WaitInLine (int[] a, int[] b) {
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swap(b, j, j + 1);
                    swap(res, j, j + 1);
                } else if (a[j] == a[j + 1]) {
                    if (b[j] > b[j + 1]) {
                        swap(a, j, j + 1);
                        swap(b, j, j + 1);
                        swap(res, j, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public void swap (int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
