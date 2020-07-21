package New.Test13;

/**
 * Created by Elvis on 2020/7/20.
 */
public class divide {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6, 7, 11};
        int target = 5;
        int res = divide(array, target);
        System.out.println(res);
    }

    public static int divide(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
