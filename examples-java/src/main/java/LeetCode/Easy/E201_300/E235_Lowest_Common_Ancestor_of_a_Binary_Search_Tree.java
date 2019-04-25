package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common
 * ancestor (LCA) of two given nodes in the BST.
 * https://leetcode.com/submissions/detail/185833304/
 * Created by liuxiang on 2018/10/28.
 */
public class E235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(9);
        n5.left = n1;
        n5.right = n7;
        n1.left = t;
        n1.right = n3;
        n3.left = n2;
        n3.right = n4;
        n7.left = n6;
        n7.right = n8;

//        Utils.printLevelTree(n5);
        TreeNode treeNode = lowestCommonAncestor(n5, n1, n7);
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
