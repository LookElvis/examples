package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of
 * its nodes' values. (ie, from left to right, level by level from leaf to root).
 * https://leetcode.com/submissions/detail/181527738/
 * Created by liuxiang on 2018/10/9.
 */
public class E107_Binary_Tree_Level_Order_TraversalII {
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

        List<List<Integer>> result = levelOrderBottom(t1);
        System.out.println(result);
        for(int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp;
        int depth = maxDepth(root);
        for (int i = depth-1; i >= 0; i--) {
            temp = new ArrayList<>();
            traverseByLevel(root, temp, i);
            list.add(temp);
        }

        return list;
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

    public static void traverseByLevel(TreeNode root, List<Integer> list, int level) {
        if(root == null) {
            return;
        }
        if(level == 0) {
            list.add(root.val);
        }
        if(root.left != null) {
            traverseByLevel(root.left, list, level-1);
        }
        if(root.right != null) {
            traverseByLevel(root.right, list, level-1);
        }
    }
}
