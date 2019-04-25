package LeetCode.Easy.E301_400;

import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given two arrays, write a function to compute their intersection.
 * https://leetcode.com/submissions/detail/187529932/
 * Created by liuxiang on 2018/11/5.
 */
public class E350_Intersection_of_Two_ArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {22};
        int[] result = intersect(nums1, nums2);
        Utils.printIntArrays(result);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pos1 = 0;
        int pos2 = 0;
        List<Integer> list = new ArrayList<>();
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                list.add(nums2[pos2]);
                pos1++;
                pos2++;
            } else if (nums1[pos1] < nums2[pos2]) {
                pos1++;
            } else {
                pos2++;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
