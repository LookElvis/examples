package New.Test14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 猿辅导笔试
 * Created by Elvis on 2020/8/1.
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int cnt = 0;
        Node root = null;
        Node[] nodes = new Node[N + 2];
        for (int i = 2; i < N + 2; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            // 基础奖励
            cnt += a;
            Node tmp = new Node(i);
            if (b == 0) {
                root = tmp;
            } else {
                nodes[b].nexts.add(tmp);
            }
            nodes[i] = tmp;
        }

        if (root == null) {
            System.out.println(0);
        } else {
            int res = maxValue(root);
//            System.out.println(maxValue(root));
            System.out.println(res + cnt);
        }
    }

    public static int maxValue(Node root) {
        if (root.nexts.size() == 0) {
            return Math.max(0, root.val);
        }
        int maxCnt = 0;
        Node t;
        for (int i = 0; i < root.nexts.size(); i++) {
            t = root.nexts.get(i);
            maxCnt += Math.max(0, maxValue(t));
        }
        return maxCnt;
    }
}
class Node {
    int val;
    List<Node> nexts;
    public Node(int val) {
        this.val = val;
        nexts = new ArrayList<>();
    }
}
