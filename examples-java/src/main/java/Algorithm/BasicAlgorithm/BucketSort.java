package Algorithm.BasicAlgorithm;

/**
 * 桶排序
 * Created by liuxiang on 2019/5/26.
 */
public class BucketSort {
    public static void main(String[] args) {
        int a[] = {1, 2, 2, 7, 4, 9, 3, 5};
        //设定数组最大值，若不直接指定，可以用一个O(n)的函数来求最大值
        int max = 9;
        //调用桶排序算法
        bucketSort(a, max);
        //输出排序后结果
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void bucketSort(int a[], int max) {
        int b[] = new int[max + 1];
        int count = 0;

        //将数据分配到桶中
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            //对每个桶进行计数，桶中存储的该桶应有的数据个数
            b[j] += 1;
        }

        //对桶进行遍历，根据桶的顺序可以顺序输出数据
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

