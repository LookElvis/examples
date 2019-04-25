package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * https://leetcode.com/submissions/detail/182172253/
 * Created by liuxiang on 2018/10/12.
 */
public class E111_Minimum_Depth_of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        t1.left = n1;
        t1.right = n2;
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        n1.left = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        n6.right = n7;

        int result = minDepth(t1);
        System.out.println(result);
    }

    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        } else if(root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        } else {
            int res = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            return res;
        }
    }
}
