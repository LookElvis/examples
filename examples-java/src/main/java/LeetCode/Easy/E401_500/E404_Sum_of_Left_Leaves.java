package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * https://leetcode.com/submissions/detail/188577394/
 * Created by liuxiang on 2018/11/10.
 */
public class E404_Sum_of_Left_Leaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        int result = sumOfLeftLeaves(root);
        System.out.println(result);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    public static int helper(TreeNode node, boolean isLeft) {
        if (node != null) {
            if (node.left == null && node.right == null && isLeft) {
                return node.val;
            }
            return helper(node.left, true) + helper(node.right, false);
        }
        return 0;
    }
}
