package Algorithm.BasicAlgorithm;

/**
 * Created by Elvis on 2019/12/9.
 */
public class Practice {
	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 4, 6, 3, 6, 4, 2, 2, 8};
		//bubble sort
//		bubbleSort(array);
		//selection sort
//		 selectionSort(array);
		//insertion sort
//		 insertionSort(array);
		//merge sort
//		 mergeSort(array, 0, array.length - 1);
		//quick sort
		quickSort(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void quickSort(int[] array, int l, int r) {
		if (l < r) {
			int[] p = partition(array, l, r);
			quickSort(array, l, p[0] - 1);
			quickSort(array, p[1] + 1, r);
		}
 	}

 	public static int[] partition(int[] array, int l, int r) {
 		int pivlot = array[l + (int) Math.random() * (r - l + 1)];
 		int p0 = l - 1;
 		int p2 = r + 1;
 		while (l < p2) {
 			if (array[l] < pivlot) {
 				swap(array, ++p0, l++);
 			} else if (array[l] > pivlot) {
 				swap(array, --p2, l);
 			} else {
 				l++;
 			}
 		}
 		return new int[]{p0 + 1, p2 - 1};
 	}

	public static void mergeSort(int[] array, int l, int r) {
		if (l == r) {
			return;
		}
		int m = l + ((r - l) >> 1);
		mergeSort(array, l, m);
		mergeSort(array, m + 1, r);
		merge(array, l, m, r);
	}

	public static void merge (int[] array, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = m + 1;
		int i = 0;
		while (p1 <= m && p2 <= r) {
			help[i++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
		}
		while (p1 <= m) {
			help[i++] = array[p1++];
		}
		while (p2 <= r) {
			help[i++] = array[p2++];
		}
		for (i = 0; i < help.length; i++) {
			array[l + i] = help[i];
		}
 	}

	public static void insertionSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; array[j] > array[j + 1] && j >= 0; j--) {
				swap(array, j, j + 1);
			}
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

	public static void bubbleSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
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
