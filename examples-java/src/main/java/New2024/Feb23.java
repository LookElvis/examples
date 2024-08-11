package New2024;


import java.util.*;

public class Feb23 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Long> countList = new ArrayList<>();
        while (!queue.isEmpty()) {
            long levelCount = 0;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode tmp = queue.poll();
                levelCount += tmp.val;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            countList.add(levelCount);
        }
        if (countList.size() < k) {
            return -1;
        }
        Collections.sort(countList);
        return countList.get(countList.size() - k);
    }
}
