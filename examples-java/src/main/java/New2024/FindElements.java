package New2024;

import java.util.HashSet;
import java.util.Set;

// March 12
public class FindElements {
    Set<Integer> elementSet = new HashSet<>();
    public FindElements(TreeNode root) {
        dfs(root, 0);
    }
    public boolean find(int target) {
        return elementSet.contains(target);
    }
    public void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        elementSet.add(val);
        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }
}
