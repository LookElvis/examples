package Algorithm.Bilibili.TreeTranverse;

import LeetCode.PublicClass.TreeNode;

import java.util.Stack;

/**
 * Created by Elvis on 2019/12/20.
 */
public class SufOrderUnRecur {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(8);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        sufOrderUnRecur(root);
    }

    public static void sufOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }   
            }
            while (!stack2.empty()) {
                System.out.print(stack2.pop().val + " ");
            }
        }
    }
}
