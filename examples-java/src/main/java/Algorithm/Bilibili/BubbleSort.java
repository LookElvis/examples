package Algorithm.Bilibili;

/**
 * Created by Elvis on 2019/12/5.
 */
public class BubbleSort {
	public static void main (String[] args) {
		int[] array = new int[] {3, 6, 13, 5, 3, 2, 7, 9};
		bubbleSort(array);
		for (int i : array) {
			System.out.print(i + " ");
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
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
