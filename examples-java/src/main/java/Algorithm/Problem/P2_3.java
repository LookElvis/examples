package Algorithm.Problem;

import LeetCode.PublicClass.Utils;

/**荷兰国旗问题
 * Created by Elvis on 2019/12/8.
 */
public class P2_3 {
    public static void main(String[] args) {
        int[] array = new int[] {4, 1, 3, 5, 0, 6, 2, 2};
        int[] result = partition(array, 0, array.length - 1);
        Utils.printIntArrays(array);
        System.out.println();
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] partition(int[] array, int l, int r) {
        int pivot = array[r];
    	int i = l - 1;
    	int j = r + 1;
        while (l < j) {
    		if (array[l] < pivot) {
                swap(array, ++i, l++);
    		} else if (array[l] > pivot) {
    		    swap(array, --j ,l);
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
