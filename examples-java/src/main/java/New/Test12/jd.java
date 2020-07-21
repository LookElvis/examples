package New.Test12;

/**京东
 * Created by Elvis on 2020/7/19.
 */
public class jd {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8};
        int res = findMissing(arr);
        System.out.println(res);
    }

    public static int findMissing(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (array[mid] == mid + 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }
}
