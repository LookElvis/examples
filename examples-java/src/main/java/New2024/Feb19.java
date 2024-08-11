package New2024;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Feb19 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        tranverse(root);
        return res;
    }

    public void tranverse(Node root) {
        if (root == null) {
            return;
        }

        for (Node n: root.children) {
            tranverse(n);
        }
        res.add(root.val);
    }
}
