package Algorithm.Sort;

/**
 * Created by Elvis on 2019/11/26.
 */
public class M75_Sort_Colors {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[c] = i;
                c++;
            }
        }
    }
}
