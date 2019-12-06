package Algorithm.BasicAlgorithm;

/**
 * Created by Elvis on 2019/12/5.
 */
public class MergeSort {
	public static void main (String[] args) {
		int[] array = new int[] {3, 6, 13, 5, 3, 2, 7, 9};
		qSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void qSort(int[] array, int l, int r) {
		if (l == r) {
			return;
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
