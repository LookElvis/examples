package New.Test18;

import java.util.*;

/**
 * Created by Elvis on 2020/8/15.
 */
public class demo4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            list.add(new Node(x, y));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x != o2.x) {
                    return o2.x - o1.x;
                } else {
                    return o2.y - o1.y;
                }
            }
        });
        int count = 0;
        for (int i = 0; i < a; i++) {
            count += list.get(i).x;
        }
        for (int i = a; i < a + b; i++) {
            count += list.get(i).y;
        }
        System.out.println(count);
    }
}
class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
