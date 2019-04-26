package LeetCode.Easy.E401_500;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 * Created by liuxiang on 2018/11/14.
 */
public class E434_Number_of_Segments_in_a_String {
    public static void main(String[] args) {
        String s = " Hello, my name is   John  ";
        int result = countSegments(s);
        System.out.println(result);
    }

    public static int countSegments(String s) {
        int count = 0;
        String[] strings = s.split(" ");
        for (String temp : strings) {
            if (temp.length() != 0 && temp != null) {
                count++;
            }
        }
        return count;
    }
}
