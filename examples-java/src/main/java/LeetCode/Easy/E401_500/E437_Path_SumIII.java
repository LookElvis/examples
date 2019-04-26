package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * https://leetcode.com/submissions/detail/189636121/
 * Created by liuxiang on 2018/11/15.
 */
public class E437_Path_SumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(5);
        TreeNode t9 = new TreeNode(1);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;

        int result = pathSum(root, 22);
        System.out.println(result);
    }

    public static int count = 0;

    public static int pathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<>();
        count = 0;

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            helper(temp, sum);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        return count;
    }

    public static void helper(TreeNode root, int sum) {
        if (root != null) {
            if (sum - root.val == 0) {
                count ++;
            }
            helper(root.left, sum - root.val);
            helper(root.right, sum - root.val);
        }
    }
 }
