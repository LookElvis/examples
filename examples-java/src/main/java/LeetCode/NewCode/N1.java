package LeetCode.NewCode;

import LeetCode.PublicClass.TreeNode;

/**
 * minimum-depth-of-binary-tree
 * Created by Elvis on 2020/1/14.
 */
public class N1 {
    public static void main(String[] args) {

    }

    public int run(TreeNode root) {
        if (root == null) return 0;
        int left = run(root.left);
        int right = run(root.right);
        if (left * right > 0) {
            return Math.min(left, right) + 1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
