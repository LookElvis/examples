package New.Test11;

/**
 * Created by Elvis on 2020/4/15.
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 第二题：请用java实现以下shell脚本的功能
 * 找出包含login的，去重，排序
 * cat /home/admin/logs/webx.log | grep "Login" | uniq -c | sort -nr
 */
public class demo2 {
    public static void main(String[] args) {
        //模拟log
        String[] lines = new String[] {
                "login 123",
                "34 login",
                "34 login",
                "fd",
                "aef gg login"
        };
        //调用
        setShell(lines);
    }

    public static void setShell(String[] lines) {
        if (lines == null || lines.length == 0) {
            System.out.println("empty");
        }
        Set<String> set = new TreeSet<>();
        for (String t : lines) {
            if (t.contains("login")) {
                set.add(t);
            }
        }
        //输出
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
