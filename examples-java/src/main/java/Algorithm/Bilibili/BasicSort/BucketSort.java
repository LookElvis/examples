package Algorithm.Bilibili.BasicSort;

/**
 * Created by Elvis on 2019/12/17.
 */
public class BucketSort {
	public static void main (String[] args) {
		int[] array = new int[] {3, 6, 13, 5, 3, 2, 7, 9};
		bucketSort(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void bucketSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			max = array[i] > max ? array[i] : max; 
		}
		int[] bucket = new int[max + 1];
		for (int i = 0; i < array.length; i++) {
			bucket[array[i]]++;
		}
		int i = 0;
		for (int j = 0; j < bucket.length; j++) {
			while (bucket[j]-- > 0) {
				array[i++] = j;
			}
		}
	}
}
