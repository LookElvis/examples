package New.Test11;

/**
 * 阿里妈妈
 * Created by Elvis on 2020/4/15.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 第一题：数据化运营 Log日志分析
 * Log文件一行是一条记录，字段中间用空格分开 如： Read: path not find error
 * 假设第一个字段是错误类型
 *
 * 需求是， 我输入一个错误类型，返回出现了几次
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String t;
        String key;
        while (input.hasNext()) {
            t = input.nextLine();
            //停止输入
            if (t.equals("exit")) {
                break;
            }
            key = t.split(" ")[0];
            System.out.println(key);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        //test
        String type = "Read:";
        System.out.println(getCount(type));
    }
    static Map<String, Integer> map = new HashMap<>();
    public static int getCount(String type) {
        return map.getOrDefault(type, 0);
    }
}

//Read: path not find error
//Write: path not find error
//Read: path not find error
//Read: path not find error