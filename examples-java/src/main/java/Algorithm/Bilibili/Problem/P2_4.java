package Algorithm.Bilibili.Problem;

/**
 * Created by Elvis on 2019/12/17.
 */
public class P2_4 {
    public static void main(String[] args) {
    	int[] arr = new int[] {14, 53, 24, 6, 15, 28};
    	int result = maxGap(arr);
    	System.out.println(result);
    }

    public static int maxGap(int[] arr) {
    	if (arr == null || arr.length < 2) {
    		return 0;
    	}
    	int len = arr.length;
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	for (int i = 0; i < len; i++) {
    		min = Math.min(min, arr[i]);
    		max = Math.max(max, arr[i]);
    	}
    	if (max == min) {
    		return 0;
    	}
    	boolean[] hasNum = new boolean[len + 1];
    	int[] maxs = new int[len + 1];
    	int[] mins = new int[len + 1];
    	int bid = 0;
    	for (int i = 0; i < len; i++) {
    		bid = bucket(arr[i], min, max, len);
            mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(arr[i], maxs[bid]) : arr[i];
    		hasNum[bid] = true;
    	}
    	int res = 0;
    	int lastMax = maxs[0];
    	int i = 1;
    	for (; i <= len; i++) {
    		if (hasNum[i]) {
    			res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
    		}
    	}
    	return res;
    }

    public static int bucket(long num, long min, long max, long len) {
    	return (int) ((num - min) * len / (max - min));
    }
}
