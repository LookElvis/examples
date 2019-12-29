package LeetCode.WeekExam.Week169;

import LeetCode.PublicClass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elvis on 2019/12/29.
 */
public class M1230 {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> list1 = new ArrayList<>();
    public ArrayList<Integer> list2 = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        tranverse1(root1);
        tranverse2(root2);
        ArrayList<Integer> list = new ArrayList<>();
        // System.out.print(list1.size());
        // for (int i = 0; i < list1.size(); i++) {
        //     System.out.print(list1.get(i) + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < list2.size(); i++) {
        //     System.out.print(list2.get(i) + " ");
        // }
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                list.add(list1.get(i));
                i++;
            } else {
                list.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }
        return list;
    }

    public void tranverse1(TreeNode root) {
        if (root == null) return;
        tranverse1(root.left);
        list1.add(root.val);
        //System.out.println(root.val);
        tranverse1(root.right);
    }

    public void tranverse2(TreeNode root) {
        if (root == null) return;
        tranverse2(root.left);
        list2.add(root.val);
        tranverse2(root.right);
    }
}
