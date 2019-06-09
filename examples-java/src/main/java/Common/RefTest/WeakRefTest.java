package Common.RefTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/**
 * Created by liuxiang on 2019/6/8.
 */
public class WeakRefTest {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer a = new Integer(1);
        Integer b = new Integer(2);

        hashMap.put(a, "1");
        weakHashMap.put(a, "1");
        weakHashMap.put(b, "2");

        // 当前对于a仍然有hashMap对它进行强引用，因此经过GC后也不会对对象a、b造成影响
        // 若解除该句屏蔽，则对于a只有一个弱引用，经过GC后，在weakHashMap中不会再有对象a，只有对象b
//        hashMap.remove(a);
        a = null;
        System.gc();

        Iterator<Integer> it = weakHashMap.keySet().iterator();
        while (it.hasNext()) {
            int t = it.next();
            System.out.println(t + ":" + weakHashMap.get(t));
        }
    }
}
