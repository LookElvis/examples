package New.Test8;

import PublicClass.Utils;

import java.util.*;

/**
 * 网易互娱
 * Created by Elvis on 2020/4/11.
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());  //数据条数
        //初始数据
        List<Data> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] t = input.nextLine().split(" ");
            list1.add(new Data(t[0], t[1]));
        }
//        Utils.printArrayList(list1);
        //内连接
        List<Data> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            String t1 = list1.get(i).tbname1;
            String u1 = list1.get(i).username1;
            for (int j = 0; j < list1.size(); j++) {
                String t2 = list1.get(j).tbname1;
                String u2 = list1.get(j).username1;
                if (u1.equals(u2) && !t1.equals(t2)) {
                    list2.add(new Data(t1, t2, u1, u2));
                }
            }
        }
//        System.out.println(list2.size());
//        Utils.printArrayList(list2);

        //groupby分组
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.size(); i++) {
            String key = list2.get(i).tbname1 + " " + list2.get(i).tbname2;
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        //迭代获取
        List<String> keys = new ArrayList<>();
        for (Map.Entry t : map.entrySet()) {
            if ((int)t.getValue() > 2) {
                keys.add(t.getKey().toString());
//                System.out.println(t.getKey().toString() + " " + t.getValue());
            }
        }
//        Utils.printArrayList(keys);
        List<Result> res = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) { //针对每个key
            // 每个key内部对username去重
            Set<String> set = new HashSet<>();
            for (int j = 0; j < list2.size(); j++) {  //遍历list
                Data tData = list2.get(j);
                if (keys.get(i).equals(tData.tbname1 + " " + tData.tbname2)) {
                    set.add(tData.username1);
                }
            }
            res.add(new Result(keys.get(i), set.size()));
        }

//        Utils.printArrayList(res);
        //最后根据res的value升序
        Collections.sort(res, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                return o1.value - o2.value;
            }
        });
//        Utils.printArrayList(res);
        //输出结果
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).key + " " + res.get(i).value);
        }
    }
}

class Result {
    public String key;
    public int value;

    public Result(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}' + "\n";
    }
}

class Data {
    public String tbname1;
    public String tbname2;
    public String username1;
    public String username2;

    public Data(String tbname1, String username1) {
        this.tbname1 = tbname1;
        this.username1 = username1;
    }

    public Data(String tbname1, String tbname2, String username1, String username2) {
        this.tbname1 = tbname1;
        this.tbname2 = tbname2;
        this.username1 = username1;
        this.username2 = username2;
    }

    @Override
    public String toString() {
        return "Data{" +
                "tbname1='" + tbname1 + '\'' +
                ", tbname2='" + tbname2 + '\'' +
                ", username1='" + username1 + '\'' +
                ", username2='" + username2 + '\'' +
                '}' + "\n";
    }
}


