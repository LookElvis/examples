package Algorithm.Bilibili.BasicSort;

/**
 * Created by Elvis on 2020/2/8.
 */
public class Test {
    public static void main(String[] args) {
    	int[] arr = new int[]{1, 3, 7, 4, 8, 2};
		mergeSort(arr, 0, arr.length - 1);
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}
    }

    public static void mergeSort(int[] arr, int l, int r) {
    	if (l == r) {
    		return;
    	}

    	int mid = l + ((r - l) >> 1);
    	mergeSort(arr, l, mid);
    	mergeSort(arr, mid + 1, r);
    	merge(arr, l, mid + 1, r);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
    	int[] helper = new int[right - left + 1];
    	int i = left;
    	int j = mid;
    	int index = 0;
    	while (i < mid && j < right) {
    		helper[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    	}
    	while (i < mid) {
    		helper[index++] = arr[i++];
    	}
    	while (j < right) {
    		helper[index++] = arr[j++];
    	}
    	for (int t = 0; t < helper.length; t++) {
    		arr[left + t] = helper[t];
    	}
    }
}
