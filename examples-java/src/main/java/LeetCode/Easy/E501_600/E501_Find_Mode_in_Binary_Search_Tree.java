package LeetCode.Easy.E501_600;

import LeetCode.PublicClass.TreeNode;
import LeetCode.PublicClass.Utils;

import java.util.*;

/**
 * Created by liuxiang on 2019/3/19.
 */
public class E501_Find_Mode_in_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(2);
        root.right = t1;
        t1.left = t2;
        int[] result = findMode(root);
        Utils.printIntArrays(result);
    }

    public static Map<Integer, Integer> map;
    public static int[] findMode(TreeNode root) {
        map = new HashMap<>();
//        Collections.sort();





        return null;
    }
}
