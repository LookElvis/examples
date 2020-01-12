package LeetCode.WeekExam.Week171;

import java.util.*;

/**
 * Created by Elvis on 2020/1/12.
 */
public class M1238 {
    public static void main(String[] args) {

    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node t = new Node(i);
            nodes.add(t);
        }
        initSet(nodes);
        for (int i = 0; i < connections.length; i++) {
            Node n1 = new Node(connections[i][0]);
            Node n2 = new Node(connections[i][1]);
            if (isSameSet(n1, n2)) {
                unionSet(n1, n2);
            }
        }
        System.out.println(fatherMap.size());
        System.out.println(sizeMap.size());
        return n - sizeMap.size() + 1;
    }

    public HashMap<Node, Node> fatherMap;
    public HashMap<Node, Integer> sizeMap;

    public class Node {
        public int x;
        public Node(int x) {
            this.x = x;
        }
    }

    public void initSet(List<Node> nodes) {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Node n : nodes) {
            fatherMap.put(n, n);
            sizeMap.put(n, 1);
        }
    }

    public Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            father = fatherMap.get(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public boolean isSameSet(Node n1, Node n2) {
        return findHead(n1) == findHead(n2);
    }

    public void unionSet(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return;
        }
        n1 = findHead(n1);
        n2 = findHead(n2);
        if (n1 != n2) {
            int n1Size = sizeMap.get(n1);
            int n2Size = sizeMap.get(n2);
            if (sizeMap.get(n1) <= sizeMap.get(n2)) {
                fatherMap.put(n1, n2);
                sizeMap.put(n1, n1Size + n2Size);
            } else {
                fatherMap.put(n2, n1);
                sizeMap.put(n2, n1Size + n2Size);
            }
        }
    }
}
