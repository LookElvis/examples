package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

/**
 * https://leetcode.com/problems/construct-the-rectangle/
 * https://leetcode.com/submissions/detail/191407968/
 * Created by liuxiang on 2018/11/23.
 */
public class E492_Construct_the_Rectangle {
    public static void main(String[] args) {
        int area = 10;
        int[] rectangle = constructRectangle(area);
        Utils.printIntArrays(rectangle);
    }

    public static int[] constructRectangle(int area) {
        int edge = (int) Math.sqrt(area);
        int left = edge;
        int right = edge;

        while (left >= 1 && right <= area) {
            int tempArea = left * right;
            if (tempArea == area) {
                return new int[] {right, left};
            } else if (tempArea < area) {
                right++;
            } else {
                left--;
            }
        }

        return new int[0];
    }
}
