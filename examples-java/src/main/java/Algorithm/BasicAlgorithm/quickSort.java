package Algorithm.BasicAlgorithm;

import java.util.Arrays;

/**
 * 快排
 * Created by liuxiang on 2019/4/19.
 */
public class quickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 2, 8};
//        qSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

//    public static int qSort(int[] array) {
//        if (array.length < 2) {
//            return array[0];
//        } else {
//            int pivot = array[0];
//
//
//        }
//    }
}
