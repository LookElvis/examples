package Algorithm.Sort;

import LeetCode.PublicClass.Utils;

import java.util.*;

/**
 * Created by liuxiang on 2019/11/22.
 */
public class E349_Intersection_of_Two_Arrays {
    public static void main(String[] args) {
    	int nums1[] = new int[]{1,2,2,1};
		int nums2[] = new int[]{2,2,3,1};
		int result[] = intersection(nums1, nums2);
		Utils.printIntArrays(result);
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> num1 = new HashSet<>();
		Set<Integer> num2 = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			num1.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			num2.add(nums2[i]);
		}

		int count = 0;
		int[] result = new int[nums1.length + nums2.length];
		Iterator<Integer> it = num1.iterator();
		while (it.hasNext()) {
			int t = it.next();
			if (num2.contains(t)) {
				result[count] = t;
				count++;
			}
		}
//		int r[] = new int[count];
//		for (int i = 0; i < count; i++) {
//			r[i] = result[i];
//		}

    	return Arrays.copyOf(result, count);
	}
}
