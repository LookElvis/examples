package LeetCode.Easy.E401_500;

/**
 * Find the largest palindrome made from the product of two n-digit numbers.
 * Since the Result could be very large, you should return the largest palindrome mod 1337.
 * https://leetcode.com/submissions/detail/191009121/
 * Created by liuxiang on 2018/11/22.
 */
public class E479_Largest_Palindrome_Product {
    public static void main(String[] args) {
        int n = 5;
        int result = largestPalindrome(n);
        System.out.println(result);
    }

    public static int largestPalindrome(int n) {
        if (n==1) return 9;
        int max=(int)Math.pow(10, n)-1;
        for (int v=max-1;v>max/10;v--) {
            long u=Long.valueOf(v+new StringBuilder().append(v).reverse().toString());
            for (long x=max;x*x>=u;x--)
                if (u%x==0)
                    return (int)(u%1337);
        }
        return 0;
    }

    public static int largestPalindrome1(int n) {
        if (n == 1) {
            return 9;
        }

        int max = (int) Math.pow(10, n) - 1;
        long muti = 0;
        for (int i = max; i > max / 10; i--) {
            for (int j = i; j >= 0; j--) {
                if (isPalindrome(i * j)) {
                    muti = i * j > muti ? i * j : muti;
                }
            }
        }

        return (int) muti % 1337;
    }

    public static boolean isPalindrome(long num) {
//        StringBuilder stringBuilder = new StringBuilder(Long.toString(num));
//        return num == Long.parseLong(stringBuilder.reverse().toString());
        String temp = Long.toString(num);
        for (int i = 0, j = temp.length() - 1; i < j; i++, j--) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
        }
//        System.out.println(num);
        return true;
    }
}
