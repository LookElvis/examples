package Algorithm.CCF.C3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/2.
 */
public class C201509 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String first = input.nextLine();
        int m = Integer.parseInt(first.split(" ")[0]);
        int n = Integer.parseInt(first.split(" ")[1]);

        String[] modules = new String[m];
        for (int i = 0; i < m; i++) {
            modules[i] = input.nextLine();
        }

        String[] values = new String[n];
        for (int i = 0; i < n; i++) {
            values[i] = input.nextLine();
        }

        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            String temp = values[j];
            String a = temp.split(" ")[0];
            String b = temp.substring(temp.indexOf("\"") + 1, temp.length() - 1);
//            System.out.println(a + " " + b);
            map.put(a, b);
        }

        for (int j = 0; j < m; j++) {
            String temp = modules[j];
            while ((temp.contains("{{")) && (temp.contains("}}"))) {
                int index1 = temp.indexOf("{{");
                int index2 = temp.indexOf("}}");

                String a = temp.substring(0, index1);
                String b = temp.substring(index1 + 3, index2 - 1);
                String c = temp.substring(index2 + 2);

                String bb = map.containsKey(b) ? map.get(b) : "";
                temp = a.concat(bb).concat(c);
            }
            modules[j] = temp;
        }

        for (int i = 0; i < m; i++) {
            System.out.println(modules[i]);
        }
    }
}

//11 2
//< !DOCTYPE html>
//< html>
//< head>
//< title>User {{ name }}</title>
//< /head>
//< body>
//< h1>{{ name }}</h1>
//< p>Email: <a href="mailto:{{ email }}">{{ email }}</a></p>
//< p>Address: {{ address }}</p>
//< /body>
//< /html>
//name "David Beckham"
//email "david@beckham.com"