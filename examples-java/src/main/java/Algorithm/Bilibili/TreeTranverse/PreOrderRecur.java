package Algorithm.Bilibili.TreeTranverse;

import PublicClass.TreeNode;

/**
 * Created by Elvis on 2019/12/20.
 */
public class PreOrderRecur {
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
        preOrderRecur(root);
    }

    public static void preOrderRecur(TreeNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}
