package Algorithm.CCF.C3;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/27.
 */
public class C201403 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String d = input.nextLine();
        char[] dd = d.toCharArray();

        //0为不带参数，1为带参数
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < dd.length - 1; i++) {
            if (dd[i + 1] != ':') {
                map1.put("-" + dd[i], 0);
            } else {
                map1.put("-" + dd[i], 1);
                i++;
            }
        }
        if (dd[dd.length - 1] != ':') {
            map1.put("-" + dd[dd.length - 1], 0);
        }

        int n = Integer.parseInt(input.nextLine());
        String[] aa = new String[n];
        for (int i = 0; i < n; i++) {
            aa[i] = input.nextLine();
        }

        for (int i = 1; i <= n; i++) {
            Map<String, String> map2 = new TreeMap<>();
            String t = aa[i - 1];
            String[] tm = t.split(" ");
            if (tm.length != 1) {
                for (int j = 1; j < tm.length; j++) {
                    if (map1.containsKey(tm[j])) {
                        if (map1.get(tm[j]) == 0) {
                            map2.put(tm[j], "");
                        } else {
                            if ((j + 1) < tm.length) {
                                map2.put(tm[j], tm[j + 1]);
                                j++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }

            Set<String> set = map2.keySet();
            Iterator<String> it = set.iterator();
            System.out.print("Case " + i + ":");
            while (it.hasNext()) {
                String k = it.next();
                String v = map2.get(k);
                if (v.equals("")) {
                    System.out.print(" " + k);
                } else {
                    System.out.print(" " + k + " " + v);
                }
            }
            System.out.println();
        }
    }
}

//albw:x
//4
//ls -a -l -a documents -b
//ls
//ls -w 10 -x -w 15
//ls -a -b -c -d -e -l
