package Common.AlgrithmTest;

import java.util.*;

/**
 * 使用LinkedHashMap的两种实现
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

    /**
     * LinkedHashMap 实现
     * put /get 操作 O(1)
     * 特殊情况：缓存已满，需要删除链表头
     * created by Ethan-Walker on 2019/2/16
     */
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRU(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        int val = cache.get(key);
        cache.remove(key); // 从链表中删除
        cache.put(key, val); // 添加到链尾

        return val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key); // 已经存在，链表中删除
        }

        if (capacity == cache.size()) {
            // cache 已满,删除链表头
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);// 添加到链尾
    }
}


