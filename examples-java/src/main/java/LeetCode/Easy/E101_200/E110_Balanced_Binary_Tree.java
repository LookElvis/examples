package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is height-balanced.
 * https://leetcode.com/submissions/detail/182035929/
 * Created by liuxiang on 2018/10/11.
 */
public class E110_Balanced_Binary_Tree {
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
        boolean result = isBalanced(t1);
        System.out.println(result);
    }

    public static boolean isBalanced(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        offerTree(queue, root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(Math.abs(maxDepth(node.left) - maxDepth(node.right)) > 1) {
                return false;
            }
        }
        return true;
    }

    public static void offerTree(Queue queue, TreeNode root) {
        if(root != null) {
            offerTree(queue, root.left);
            if(!(root.left == null && root.right == null)) {
                queue.offer(root);
            }
            offerTree(queue, root.right);
        }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left != null && root.right == null) {
            return maxDepth(root.left)+1;
        }
        if(root.left == null && root.right != null) {
            return maxDepth(root.right)+1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
