import PublicClass.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import scala.Int;

/**
 * Created by Elvis on 2020/6/21.
 */
public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{6, -3, -2, 7, 15, 1, 2, 2, 2};
        int res = helper(arr);
        System.out.println(res);
    }

    public static int helper(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] > 0 ? arr[i - 1] + arr[i] : arr[i];
            max = Math.max(max, arr[i]);
        }
        return max;
    }

}
