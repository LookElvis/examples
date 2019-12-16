package Algorithm.Bilibili;

/**
 * Created by Elvis on 2019/12/5.
 */
public class MergeSort {
	public static void main (String[] args) {
		int[] array = new int[] {3, 6, 13, 5, 3, 2, 7, 9};
		mergeSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void mergeSort(int[] array, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = L + (R - L) / 2;
		mergeSort(array, L, mid);
		mergeSort(array, mid + 1, R);
		merge(array, L, mid, R);
	}

	public static void merge(int[] array, int l, int m, int r) {
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
}
