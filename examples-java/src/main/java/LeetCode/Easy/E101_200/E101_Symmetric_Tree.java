package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * https://leetcode.com/submissions/detail/181505175/
 * Created by liuxiang on 2018/10/9.
 */
public class E101_Symmetric_Tree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        t1.left = n1;
        t1.right = n2;
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n3;
        n2.right = n4;

        boolean result = isSymmetric(t1);
        System.out.println(result);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isQuery(root, root);
    }

    public static boolean isQuery(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isQuery(left.left, right.right) && isQuery(left.right, right.left);
    }
}