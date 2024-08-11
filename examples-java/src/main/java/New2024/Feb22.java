package New2024;

public class Feb22 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length - 1;
        return transverse(preorder, postorder, 0, n, 0, n);
    }
    public TreeNode transverse(int[] preorder, int[] postorder, int preorder_left, int preorder_right, int postorder_left, int postorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorder_left]);
        if (preorder_left == preorder_right) {
            return root;
        }
        int postorder_index = -1;
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[i] == preorder[preorder_left + 1]) {
                postorder_index = i;
                break;
            }
        }
        root.left = transverse(preorder, postorder, preorder_left + 1, preorder_left + postorder_index - postorder_left + 1, postorder_left,  postorder_index);
        root.right = transverse(preorder, postorder, preorder_left + postorder_index - postorder_left + 2, preorder_right, postorder_index + 1, postorder_right - 1);
        return root;
    }
}
