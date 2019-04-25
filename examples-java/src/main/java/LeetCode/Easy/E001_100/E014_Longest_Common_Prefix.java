package LeetCode.Easy.E001_100;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * https://leetcode.com/problems/longest-common-prefix/solution/
 * Created by liuxiang on 2018/9/19.
 */
public class E014_Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] strs = {"","cbc","c","ca"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }

        int minLenth = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < minLenth) {
                minLenth = strs[i].length();
            }
        }

        if(minLenth == 0) {
            return "";
        }

        int j = 0;
        boolean isStop = false;
        for (; j < minLenth; j++) {
            for (int m = 1; m < strs.length; m++) {
                char temp = strs[m-1].charAt(j);
                if(strs[m].charAt(j) != temp) {
                    isStop = true;
                    break;
                }
            }
            if(isStop){
                break;
            }
        }

        if(j != 0) {
            return strs[0].substring(0, j);
        } else {
            return "";
        }
    }

}
