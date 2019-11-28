package Algorithm.Sort;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Elvis on 2019/11/28.
 */
public class M179_Largest_Number {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 30, 9, 5, 34};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });

        if (strings[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }

        return sb.toString();
    }
}
