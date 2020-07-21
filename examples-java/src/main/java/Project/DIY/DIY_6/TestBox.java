package Project.DIY.DIY_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liuxiang on 2018/7/9.
 */
public class TestBox {
    public static void main(String[] args) {
//        int a = 0;
        String a = "dd";
        Box box = new Box(a);
        System.out.println(box.getData());
        List<String> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        Collections.copy(list2, list1);
        int[] b = {1, 2, 3};
//        Arrays.New.Test13.sort(b, new Comparator);
    }

}
