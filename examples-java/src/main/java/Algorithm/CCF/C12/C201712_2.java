package Algorithm.CCF.C12;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/22.
 */
public class C201712_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

//        Queue<Integer> queue = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            queue.offer(i + 1);
//        }
//
//        int count = 1;
//        while (queue.size() > 1) {
//            int t = queue.poll();
//            if ((count % k != 0) && (count % 10 != k)) {
//                queue.offer(t);
//            }
//            count++;
//        }
//        System.out.println(queue.poll());

//        int count = 1;
//        List<Integer> list1 = new ArrayList<>();
//        while (list.size() > 1) {
//            for (int i = 0; i < list.size(); i++) {
//                if (count % k == 0 || count % 10 == k) {
//                    list1.add(list.get(i));
//                }
//                count++;
//            }
//
//            for (int j = 0; j < list1.size(); j++) {
//                list.remove(list1.get(j));
//                if (list.size() == 1) {
//                    break;
//                }
//            }
//            list1.clear();
//        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        int count = 1;
        List<Integer> list1 = new ArrayList<>();
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (count % k == 0 || count % 10 == k) {
                    list1.add(list.get(i));
                }
                count++;
            }

            for (int j = 0; j < list1.size(); j++) {
                list.remove(list1.get(j));
                if (list.size() == 1) {
                    break;
                }
            }
            list1.clear();
        }

        System.out.print(list.get(0));
    }
}
