package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.TreeNode;
import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * https://leetcode.com/submissions/detail/186031505/
 * Created by liuxiang on 2018/10/29.
 */
public class E257_Binary_Tree_Paths {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(5);
        treeNode.left = t1;
        treeNode.right = t2;
        t1.right = t3;

        List<String> result = binaryTreePaths(treeNode);
        Utils.printArrayList(result);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queueNode= new LinkedList<>();
        Queue<String> queueString = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queueNode.add(root);
        queueString.add(root.val + "");
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.remove();
            String str = queueString.remove();
            if (node.left == null && node.right == null) {
                list.add(str);
            }
            if (node.left != null) {
                queueNode.add(node.left);
                queueString.add(str + "->" + node.left.val);
            }
            if (node.right != null) {
                queueNode.add(node.right);
                queueString.add(str + "->" + node.right.val);
            }
        }
        return list;
    }
}
