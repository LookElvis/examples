package Algorithm.Bilibili.BasicSort;

import PublicClass.Utils;

/**
 * Created by Elvis on 2019/12/16.
 */
public class HeapSort {
    public static void main(String[] args) {
		int[] array = new int[] {1, 3, 5, 2, 5, 2, 4, 3, 2};
		heapSort(array);
        Utils.printIntArrays(array);
    }

    public static void heapSort(int[] array) {
    	if (array == null || array.length < 2) {
    		return;
    	}
    	for (int i = 0; i < array.length; i++) {
    		heapInsert(array, i);
    	}
    	int heapSize = array.length;
    	swap(array, 0, --heapSize);
    	while (heapSize > 0) {
    		heapAdjust(array, 0, heapSize);
    		swap(array, 0, --heapSize);
    	}
    }

    public static void heapInsert(int[] array, int index) {
    	while (array[index] > array[(index - 1) / 2]) {
    		swap(array, index, (index - 1) / 2);
    		index = (index - 1) / 2;
    	}
    }

    public static void heapAdjust(int[] array, int index, int size) {
    	int left = index * 2 + 1;
    	while (left < size) {
    		int largest = left + 1 < size && array[left + 1] > array[left] ? left + 1: left;
    		largest = array[largest] > array[index] ? largest : index;
    		if (largest == index) {
    			break;
    		}
    		swap(array, largest, index);
    		index = largest;
    		left = index * 2 + 1;
    	}
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
