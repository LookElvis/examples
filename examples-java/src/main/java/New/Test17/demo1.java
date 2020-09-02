package New.Test17;

import java.util.*;

/**
 * 阿里笔试
 * Created by Elvis on 2020/8/12.
 */
public class demo1 {
    public static TreeSet<String> set = new TreeSet<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        char[] array = new char[m];
        List<Integer> list = new ArrayList<>();
        dfs(list, 1, 0, m, n);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public static void dfs(List<Integer> list, int start, int count, int m, int n) {
        if (count == n || start == list.size() - 1) {
            String t = "";
            for (int i = 0; i < list.size(); i++) {
                t += list.get(i) + " ";
            }
            set.add(t);
            return;
        }

        for (int ii = start; ii <= m; ii++) {
            //不加上当前数字dfs
            dfs(list, ii + 1, count, m, n);
            //加上当前数字dfs
            list.add(ii);
            dfs(list, ii + 1, count + 1, m, n);
            list.remove(list.size() - 1);
        }
    }
}
