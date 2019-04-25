package LeetCode.Easy.E001_100;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * https://leetcode.com/submissions/detail/178375318/
 * Created by liuxiang on 2018/9/25.
 */
public class E088_Merge_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        for(int k = 0; k < nums1.length; k++) {
            System.out.println(nums1[k]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < nums1.length; i++, j++) {
            nums1[i] = nums2[j];
        }

        int temp = 0;
        for(int k = 0; k < nums1.length-1; k++) {
            for (int l = 0; l < nums1.length-k-1; l++) {
                if(nums1[l] > nums1[l+1]) {
                    temp = nums1[l+1];
                    nums1[l+1] = nums1[l];
                    nums1[l] = temp;
                }
            }
        }
    }
}
