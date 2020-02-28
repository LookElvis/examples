package Algorithm.Bilibili.BasicSort;

import java.util.Random;

/**
 * Created by Elvis on 2020/2/8.
 */
public class Test {
    public static void main(String[] args) {
    	int[] arr = new int[]{1, 3, 7, 2, 4, 8, 2, 2};
		insertionSort(arr);
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}
    }

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;   
        }

        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int tmp = arr[i];
            while (index >= 0 && tmp < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = tmp;
        }
    }

}