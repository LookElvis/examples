package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * https://leetcode.com/submissions/detail/182189454/
 * Created by liuxiang on 2018/10/12.
 */
public class E112_Path_Sum {
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
        int sum = 9;
        boolean isTrue = hasPathSum(t1, sum);
        System.out.println(isTrue);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        return helper(root, sum);
    }

    public static boolean helper(TreeNode root, int sum) {
        if(root.left==null && root.right==null && sum == root.val) {
            return true;
        }
        boolean h1 = false;
        boolean h2 = false;
        if(root.left != null) {
            h1 = helper(root.left, sum - root.val);
        }
        if(root.right != null) {
            h2 = helper(root.right, sum - root.val);
        }
        return h1||h2;
    }

    //简洁代码
    public static boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum1(root.left, sum - root.val)||hasPathSum1(root.right, sum - root.val);
    }
}
