package Algorithm.Bilibili.BasicSort;

import java.util.Random;

/**
 * Created by Elvis on 2020/2/8.
 */
public class Test {
    public static void main(String[] args) {
    	int[] arr = new int[]{1, 3, 7, 2, 4, 8, 2, 2};
		quickSort(arr, 0, arr.length - 1);
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}
    }

    public static void quickSort(int[] arr, int l, int r) {
    	if (l < r) {
    		int[] partition = partition(arr, l, r);
    		quickSort(arr, l, partition[0]);
    		quickSort(arr, partition[1], r);
    	}
    }

    public static int[] partition(int[] arr, int l, int r) {
    	int pivlot = arr[l + (int) Math.random() * (r - l + 1)];
    	int p0 = l - 1;
    	int p2 = r + 1;
    	while (l < p2) {
    		if (arr[l] < pivlot) {
    			swap(arr, ++p0, l++);
    		} else if (arr[l] > pivlot){
    			swap(arr, --p2, l);
    		} else {
    			l++;
    		}
    	}
    	return new int[] {p0, p2};
    }

    public static void swap (int[] arr, int i, int j) {
    	if (i == j) {
    		return;
    	}
    	arr[i] ^= arr[j];
    	arr[j] ^= arr[i];
    	arr[i] ^= arr[j];
    }
}