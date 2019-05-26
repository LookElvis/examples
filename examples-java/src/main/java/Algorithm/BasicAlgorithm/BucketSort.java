package Algorithm.BasicAlgorithm;

/**
 * 桶排序
 * Created by liuxiang on 2019/5/26.
 */
public class BucketSort {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 7, 4, 9, 3, 5};
        int max = 9;
        bucketSort(a, max);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void bucketSort(int a[], int max) {
        int b[] = new int[max + 1];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            b[j] += 1;
        }

        for (int i = 0; i <= max; i++) {
            if (b[i] > 0) {
                for (int j = 0; j < b[i]; j++) {
                    a[count] = i;
                    count++;
                }
            }
        }
    }
}