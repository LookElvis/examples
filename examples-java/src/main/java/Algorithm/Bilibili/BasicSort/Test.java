package Algorithm.Bilibili.BasicSort;

/**
 * Created by Elvis on 2020/2/8.
 */
public class Test {
    public static void main(String[] args) {
    	int[] arr = new int[]{1, 3, 7, 4, 8, 2};
		insertionSort(arr);
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}
    }

    public static void insertionSort(int[] array) {
    	if (array == null || array.length < 2) {
    		return;
    	}

    	for (int i = 1; i < array.length; i++) {
    		int index = i - 1;
    		int tmp = array[i];
    		while (index >= 0 && tmp < array[index]) {
    			array[index + 1] = array[index];
    			index--;
    		}
    		array[index + 1] = tmp;
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
