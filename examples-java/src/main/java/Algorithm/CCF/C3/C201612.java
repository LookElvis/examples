package Algorithm.CCF.C3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/12.
 */
public class C201612 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //p段
        int p = Integer.parseInt(input.nextLine());
        Map<String, Integer> pp = new HashMap<>();
        for (int i = 0; i < p; i++) {
            String t = input.nextLine();
            String[] mm = t.split(":");
            String k = mm[0];
            int v = -1;
            if (mm.length == 2) {
                v = Integer.parseInt(mm[1]);
            }
            pp.put(k, v);
//            System.out.println(k + " - " + v);
        }

        //role段
        int r = Integer.parseInt(input.nextLine());
        Map<String, String> role = new HashMap<>();
        for (int i = 0; i < r; i++) {
            String t = input.nextLine();
            String[] ts = t.split(" ");
            String key = ts[0];
            String value = "";
            int length = Integer.parseInt(ts[1]);
            for (int j = 0; j < length; j++) {
                value = value + ts[j + 2] + " ";
            }
            role.put(key, value);
        }

        //user段
        int u = Integer.parseInt(input.nextLine());
        Map<String, Map<String, Integer>> user = new HashMap<>();
        for (int i = 0; i < u; i++) {
            String t = input.nextLine();
            String[] ts = t.split(" ");
            String key = ts[0];
            String value = "";
            int length = Integer.parseInt(ts[1]);
            for (int j = 0; j < length; j++) {
                String uu = ts[j + 2];
                value += role.get(uu);
            }

            Map<String, Integer> root = new HashMap<>();
            String[] gg = value.split(" ");
            for (int m = 0; m < gg.length; m++) {
                String aa = gg[m];
                String[] mm = aa.split(":");
                String k = mm[0];
                int v = -1;
                if (mm.length == 2) {
                    v = Integer.parseInt(mm[1]);
                }
                if ((!root.containsKey(k)) || (root.containsKey(k) && root.get(k) < v)) {
                    root.put(k, v);
                }
//                root.put(k, v);
            }
            user.put(key, root);
//            System.out.println(key + " - " + root);
        }

        //q段
        int q = Integer.parseInt(input.nextLine());
        String[] test = new String[q];
        for (int i = 0; i < q; i++) {
            test[i] = input.nextLine();
        }

        Map<String, String> ques = new HashMap<>();
        for (int i = 0; i < q; i++) {
            String t = test[i];
            String[] ts = t.split(" ");
            //用户名
            String name = ts[0];

            String root = ts[1];
            String[] mm = root.split(":");
            //权限名
            String k = mm[0];
            //权限等级，-1是不存在
            int v = -1;
            if (mm.length == 2) {
                v = Integer.parseInt(mm[1]);
            }

//            System.out.println(name + " " + k + " " + v);
            //用户或者权限不存在
            if (!pp.containsKey(k) || !user.containsKey(name)) {
//                System.out.println(name);
                System.out.println(false);
                continue;
            }

            if (!user.get(name).containsKey(k)) {
//                System.out.println(name);
                System.out.println(false);
            } else { //该用户具有权限，考虑输出数字或者true
                int compK = user.get(name).get(k);
                if (v == -1 && compK == -1) {
//                    System.out.println(name);
                    System.out.println(true);
                    continue;
                }
                if (v == -1 && compK != -1) {
//                    System.out.println(name);
                    System.out.println(compK);
                    continue;
                }
                if (v != -1 && compK != -1) {
                    if (v >= compK) {
//                        System.out.println(name);
                        System.out.println(true);
                    } else {
//                        System.out.println(name);
                        System.out.println(false);
                    }
                    continue;
                }
            }
        }
    }
}

//3
//crm:2
//git:3
//game
//4
//hr 1 crm:2
//it 3 crm:1 git:1 game
//dev 2 git:3 game
//qa 1 git:2
//3
//alice 1 hr
//bob 2 it qa
//charlie 1 dev
//9
//alice game
//alice crm:2
//alice git:0
//bob git
//bob poweroff
//charlie game
//charlie crm
//charlie git:3
//malice game