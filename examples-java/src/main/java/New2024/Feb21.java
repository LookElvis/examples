package New2024;

public class Feb21 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length - 1;
        return transverse(inorder, postorder, 0, n, 0, n);
    }

    public TreeNode transverse(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        if (postorder_left > postorder_right) {
            return null;
        }

        int inorder_index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder_right]) {
                inorder_index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[inorder_index]);
        root.left = transverse(inorder, postorder, inorder_left, inorder_index - 1, postorder_left, postorder_left + inorder_index - inorder_left - 1);
        root.right = transverse(inorder, postorder, inorder_index + 1, inorder_right, postorder_left + inorder_index - inorder_left, postorder_right - 1);
        return root;
    }
}
