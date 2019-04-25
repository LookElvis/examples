package LeetCode.Easy.E001_100;

import LeetCode.PublicClass.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * https://leetcode.com/submissions/detail/181483896/
 * Created by liuxiang on 2018/9/25.
 */
public class E100_Same_Tree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(3);
        t1.left = n1;
        t1.right = n2;

        TreeNode t2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        t2.left = n3;
        t2.right = n4;

        boolean result = isSameTree(t1, t2);
        System.out.println(result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        if(p != null && q != null) {
            if(p.val != q.val ) {
                return false;
            }
            result = isSameTree(p.left, q.left);
            if (!result) {
                return false;
            }
            result = isSameTree(p.right, q.right);
            if (!result) {
                return false;
            }
        } else if(p == null && q ==null) {
            return true;
        } else {
            return false;
        }

        return result;
    }
}