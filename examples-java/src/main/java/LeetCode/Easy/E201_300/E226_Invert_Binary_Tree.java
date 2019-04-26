package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.TreeNode;
import LeetCode.PublicClass.Utils;

/**
 * Invert a binary tree.
 * https://leetcode.com/submissions/detail/185381673/
 * Created by liuxiang on 2018/10/26.
 */
public class E226_Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        t.left = n1;
        t.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;

        Utils.printLevelTree(t);
        TreeNode result = invertTree(t);
        System.out.println();
        Utils.printLevelTree(result);
    }

    public static TreeNode invertTree(TreeNode root) {
        TreeNode temp1;
        TreeNode temp2;
        if (root != null) {
            temp1 = root.left;
            temp2 = root.right;
            root.left = temp2;
            root.right = temp1;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
