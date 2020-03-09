package Common.AlgrithmTest;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Elvis on 2020/3/9.
 */
public class LRU {
    public static void main(String[] args) {
        final int cacheSize = 10;
        // 当参数accessOrder为true时，即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
        // 当满足一定条件时删除老数据
        Map<String, String> map = new LinkedHashMap<String, String>((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return this.size() > cacheSize;
            }
        };

        // 保证线程安全
        Collections.synchronizedMap(map);
    }
}
