package LeetCode.Easy.E401_500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * https://leetcode.com/submissions/detail/189429390/
 * Created by liuxiang on 2018/11/14.
 */
public class E429_N_ary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {


    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();

            while (!queue1.isEmpty()) {
                Node temp1 = queue1.remove();
                l1.add(temp1.val);
                for (Node n: temp1.children) {
                    if (n != null) {
                        queue2.add(n);
                    }
                }
            }
            if (l1 != null && l1.size() != 0) {
                list.add(l1);
            }

            while (!queue2.isEmpty()) {
                Node temp2 = queue2.remove();
                l2.add(temp2.val);
                for (Node n: temp2.children) {
                    if (n != null) {
                        queue1.add(n);
                    }
                }
            }
            if (l2 != null && l2.size() != 0) {
                list.add(l2);
            }
        }

        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


}


