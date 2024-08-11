package New2024;

import java.util.LinkedList;
import java.util.List;

public class Feb25 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = findTarget(root, p);
        List<TreeNode> list2 = findTarget(root, q);

        System.out.println(list1.size());
        System.out.println(list2.size());

        int index = list1.size() > list2.size() ? list2.size() : list1.size();
        TreeNode res = null;
        for (int i = 0; i < index; i++) {
            if (list1.get(i) == list2.get(i)) {
                res = list1.get(i);
            } else {
                break;
            }
        }
        return  res;
    }

    public List<TreeNode> findTarget(TreeNode root, TreeNode target) {
        TreeNode pointer = root;
        List<TreeNode> list = new LinkedList<>();
        while (pointer != null) {
            list.add(pointer);
            if (pointer.val < target.val) {
                pointer = pointer.right;
            } else if (pointer.val > target.val) {
                pointer = pointer.left;
            } else {
                break;
            }
        }
        return list;
    }

}
