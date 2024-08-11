package New2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Feb24 {
    List<Integer> sortedList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorderTranverse(root);
        for (int i = 0; i < queries.size(); i++) {
            int minValue = -1;
            int maxValue = -1;
            int index = binarySearch(queries.get(i));
            System.out.println(index);


            if (index == sortedList.size()) {
                minValue = sortedList.get(index - 1);
                maxValue = -1;
                resultList.add(Arrays.asList(new Integer[]{minValue, maxValue}));
                continue;
            }

            if (index > 0) {
                minValue = sortedList.get(index - 1);
            }
            maxValue = sortedList.get(index);
            System.out.println(sortedList.get(index) + " " + queries.get(i));

            if (sortedList.get(index).equals(queries.get(i))) {
                System.out.println("1133");
                System.out.println(sortedList.get(index) + " " + queries.get(i));

                minValue = maxValue;
            }
            resultList.add(Arrays.asList(new Integer[]{minValue, maxValue}));
        }
        return resultList;
    }

    public void inorderTranverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTranverse(root.left);
        sortedList.add(root.val);
        inorderTranverse(root.right);
    }

    public int binarySearch(int value) {
        int left = 0;
        int right = sortedList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = sortedList.get(mid);
            if (midValue < value) {
                left = mid + 1;
            } else if (midValue >= value) {
                right = mid;
            }
        }
        return left;
    }
}
