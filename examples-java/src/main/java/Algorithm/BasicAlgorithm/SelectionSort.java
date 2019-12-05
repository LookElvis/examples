package Algorithm.BasicAlgorithm;

/**
 * Created by Elvis on 2019/12/5.
 */
public class SelectionSort {
	public static void main (String[] args) {
		int[] array = new int[] {3, 6, 13, 5, 3, 2, 7, 9};
		selectionSort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void selectionSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				minIndex = array[j] < array[minIndex] ? j : minIndex;
			}
			swap(array, i, minIndex);
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
