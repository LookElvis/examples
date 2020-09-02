package New.Test18;

import java.util.*;

/**
 * Created by Elvis on 2020/8/15.
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //订单数
        int n = input.nextInt();
        //关系数
        int m = input.nextInt();
        //初始化并查集
        UnionFindSet union = new UnionFindSet();
        union.initSet(n);
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            if (a != b) {
                union.unionSet(a, b);
            }
        }
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int head = union.findHead(i);
            map.put(head, map.getOrDefault(head, "") + i + " ");
        }
        Iterator it = map.keySet().iterator();
        System.out.println(map.size());
        while (it.hasNext()) {
            System.out.println(map.get(it.next()));
        }
    }
}
class UnionFindSet {
    public HashMap<Integer, Integer> fatherMap;

    public UnionFindSet() {
        this.fatherMap = new HashMap<>();
    }

    public void initSet(int nodes) {
        for (int i = 1; i <= nodes; i++) {
            fatherMap.put(i, i);
        }
    }

    public Integer findHead(int node) {
        int father = fatherMap.get(node);
        if (father != node) {
            father = fatherMap.get(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public void unionSet(int n1, int n2) {
        n1 = findHead(n1);
        n2 = findHead(n2);
        //不是同一个集合
        if (n1 < n2) {
            //n1作为头
            fatherMap.put(n2, n1);
        } else {
            fatherMap.put(n1, n2);
        }
    }
}
