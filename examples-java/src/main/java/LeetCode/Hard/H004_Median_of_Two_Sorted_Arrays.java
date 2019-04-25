package LeetCode.Hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
 * Created by liuxiang on 2018/10/10.
 */
public class H004_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {3,6,9,12};
        int[] nums2 = {5,7,8,10,14};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //为了节省时间，我们使用最小的数操作
        //nums1的长度始终小于nums2的长度
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        //nums1与nums2合并数组后的总长度len
        int len = nums1.length + nums2.length;
        //cut1代表nums1左边有几个数
        int cut1 = 0;
        //cut2代表nums2左边有几个数
        int cut2 = 0;
        //cutL,cutR是nums1数组中二分的查找范围
        //nums1左边的查找值
        int cutL = 0;
        //nums1右边的查找值
        int cutR = nums1.length;
        //当cut1的数目
        while(2 > 1){
            cut1 = (cutR + cutL) / 2;
            cut2 = len / 2 - cut1;

            //对nums1与nums2数组进行分割
            //nums1是否切割
            //nums2是否切割
            //不用切割的话，切割线在最左边或者最右边
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];

            //找到最好的分割
            if(L1 > R2){
                cutR = cut1 - 1;
            }else if(L2 > R1){
                cutL = cut1 + 1;
            }else{
                if(len % 2 == 0){
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                }else{
                    R1 = (R1 < R2)? R1 : R2;
                    return R1;
                }
            }
        }
        //return -1;
    }

    //O(log(m+n))
    public static double findMedianSortedArrays3(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    //O(m+n)
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            nums[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums[k++] = nums2[j++];
        }

        for (int d = 0; d < nums.length; d++) {
            System.out.println(nums[d]);
        }

        if(nums.length % 2 == 0) {
            return (nums[nums.length/2] + nums[nums.length/2-1]) / 2.0;
        } else {
            return nums[nums.length/2];
        }
    }
}
