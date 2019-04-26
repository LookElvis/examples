package LeetCode.Easy.E301_400;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * https://leetcode.com/submissions/detail/188400071/
 * Created by liuxiang on 2018/11/9.
 */
public class E400_Nth_Digit {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        int result = findNthDigit(n);
        System.out.println(result);
    }

//    public static int findNthDigit(int n) {
//        int result = 0;
//        int i;
//        for (i = 1; result < n; i++) {
//            if (i < 10) {
//                result++;
//            } else if (i < 100) {
//                result += 2;
//            } else if (i < 1000) {
//                result += 3;
//            } else if (i < 10000) {
//                result += 4;
//            } else if (i < 100000) {
//                result += 5;
//            } else if (i < 1000000) {
//                result += 6;
//            } else if (i < 10000000) {
//                result += 7;
//            } else if (i < 100000000) {
//                result += 8;
//            } else if (i < 1000000000) {
//                result += 9;
//            } else {
//                result += 10;
//            }
//        }
//        String string = i - 1 + "";
//        int index = string.length()- (result - n) - 1;
//        return Integer.parseInt(string.charAt(index) + "");
//    }

    public static int findNthDigit(int n) {
        long sum = 0;
        int pow = 1;
        while (sum < n){

            long start = (long)Math.pow(10,pow-1);
            long end = (long)Math.pow(10,pow);
            long acc =  (  end - start ) * pow;
            if(sum + acc >= n){
                long diff = n - sum;
                long num = diff / pow + start - 1;
                int rem = (int)(diff % pow);
                if(rem >  0){
                    char c = String.valueOf(num + 1).charAt(rem -1);
                    return c - '0';
                }else {
                    char c = String.valueOf(num).charAt(pow - 1);
                    return c - '0';
                }
            }
            sum += acc;
            pow ++;
        }
        return 0;
    }
}
