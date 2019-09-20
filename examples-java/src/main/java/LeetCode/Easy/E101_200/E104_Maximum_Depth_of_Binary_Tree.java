package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * https://leetcode.com/submissions/detail/181508692/
 * Created by liuxiang on 2018/10/9.
 */
public class E104_Maximum_Depth_of_Binary_Tree {
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

        int result = maxDepth(t1);
//        int Result = iterate(t1);
        System.out.println(result);
    }

    //简洁代码
    public static int iterate(TreeNode root) {
        if (root == null) return 0;
        int l = iterate(root.left);
        int r = iterate(root.right);
        return 1 + Math.max(l, r);
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
//        if(root.left == null && root.right == null) {
//            return 1;
//        }
//        if(root.left != null && root.right == null) {
//            return maxDepth(root.left)+1;
//        }
//        if(root.left == null && root.right != null) {
//            return maxDepth(root.right)+1;
//        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
