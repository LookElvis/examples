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
//        int Result = 0;
//        int i;
//        for (i = 1; Result < n; i++) {
//            if (i < 10) {
//                Result++;
//            } else if (i < 100) {
//                Result += 2;
//            } else if (i < 1000) {
//                Result += 3;
//            } else if (i < 10000) {
//                Result += 4;
//            } else if (i < 100000) {
//                Result += 5;
//            } else if (i < 1000000) {
//                Result += 6;
//            } else if (i < 10000000) {
//                Result += 7;
//            } else if (i < 100000000) {
//                Result += 8;
//            } else if (i < 1000000000) {
//                Result += 9;
//            } else {
//                Result += 10;
//            }
//        }
//        String string = i - 1 + "";
//        int index = string.length()- (Result - n) - 1;
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
