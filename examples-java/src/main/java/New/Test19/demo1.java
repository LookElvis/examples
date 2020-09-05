package New.Test19;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 网易互娱
 * Created by Elvis on 2020/9/5.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        HashMap<String, Integer> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            String tmp = input.nextLine();
            String userId = tmp.split(" ")[0];
            String userName = tmp.split(" ")[1];
            map.put(userName, map.getOrDefault(userName, 0) + 1);
            if (map.get(userName) == 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
