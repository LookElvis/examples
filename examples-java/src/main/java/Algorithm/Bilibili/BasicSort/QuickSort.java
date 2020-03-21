package Algorithm.Bilibili.BasicSort;

import PublicClass.MathUtils;
import PublicClass.Utils;

/**
 * Created by Elvis on 2019/12/8.
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = new int[] {1, 3, 5, 2, 5, 2, 4, 3, 2};
		qSort(array, 0, array.length - 1);
        Utils.printIntArrays(array);
	}

	public static void qSort(int[] array, int l, int r) {
		if (l < r) {
			int[] result = partition(array, l, r);
            qSort(array, l, result[0] - 1);
            qSort(array, result[1] + 1, r);
		}
	}

	public static int[] partition(int[] array, int l, int r) {
        int pivlot = array[l + (int) Math.random() * (r - l + 1)];
//		int pivlot = array[r];
		int i = l - 1;
		int j = r + 1;
		while (l < j) {
			if (array[l] < pivlot) {
				swap(array, ++i, l++);
			} else if (array[l] > pivlot) {
				swap(array, --j, l);
			} else {
				l++;
			}
		}
		return new int[] {i + 1, j - 1};
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
