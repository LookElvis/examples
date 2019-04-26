package LeetCode.Easy.E301_400;

import LeetCode.PublicClass.Utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * https://leetcode.com/submissions/detail/187521022/
 * Created by liuxiang on 2018/11/5.
 */
public class E349_Intersection_of_Two_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1, nums2);
        Utils.printIntArrays(result);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            boolean isTrue = (set1.contains(nums2[j])) && (!set2.contains(nums2[j]));
            if (isTrue) {
                set2.add(nums2[j]);
            }
        }

        int m = 0;
        int[] result = new int[set2.size()];
        Iterator<Integer> it = set2.iterator();
        while (it.hasNext()) {
            result[m] = it.next();
            m++;
        }
        return result;
    }
}
