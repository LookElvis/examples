package Common.CollectionsTest;

import java.util.ArrayList;

/**
 * Created by liuxiang on 2019/5/23.
 */
public class ArrayListToArray {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("testA");
        list.add("testB");
        list.add("testC");

        String[] strings = (String[]) list.toArray();
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}