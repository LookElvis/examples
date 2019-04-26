package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * https://leetcode.com/submissions/detail/215633313/
 * Created by liuxiang on 2018/11/24.
 */
public class E496_Next_Greater_ElementI {
    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] elements = nextGreaterElement(nums1, nums2);
        Utils.printIntArrays(elements);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] elements = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            boolean isGreater = false;
            int j = map.get(nums1[i]);
            for (; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    isGreater = true;
                    break;
                }
            }
            elements[i] = isGreater ? nums2[j] : -1;
        }

        return elements;
    }
}
