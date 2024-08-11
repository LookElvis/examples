package New2024;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Feb20 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return tranverse(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode tranverse(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                          int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 可以通过hashmap节省空间
        int inorder_root = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preorder_left]) {
                inorder_root = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = tranverse(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = tranverse(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
