package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/9/6.
 */
public class XiaoMi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (input.hasNext()) {
            int t = input.nextInt();
            list.add(t);
        }

        String isTrue = "True";
        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++, j--) {
            int a = list.get(i);
            int b = list.get(j);
            if (a != b) {
                isTrue = "False";
                break;
            }
        }

        System.out.println(isTrue);
    }
}
