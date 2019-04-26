package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.TreeNode;
import LeetCode.PublicClass.Utils;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * https://leetcode.com/submissions/detail/182032329/
 * Created by liuxiang on 2018/10/11.
 */
public class E108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 6, 7};
        TreeNode result = sortedArrayToBST(nums);
        Utils.printLevelTree(result);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[(nums.length-1)/2]);
        middleQuery(root, nums, 0, nums.length-1);
        return root;
    }

    public static int middleQuery(TreeNode root, int[] nums, int start, int end) {
        if(start >= 0 && start <= (start+end)/2-1) {
            root.left = new TreeNode(0);
            root.left.val = middleQuery(root.left, nums, start, (start+end)/2-1);
        }
        if(end <= nums.length-1 && (start+end)/2+1 <= end) {
            root.right = new TreeNode(0);
            root.right.val = middleQuery(root.right, nums, (start+end)/2+1, end);
        }
        return nums[(start+end)/2];
    }
}
