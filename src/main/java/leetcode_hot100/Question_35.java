package leetcode_hot100;

import java.util.LinkedHashMap;
import java.util.Map;

public class Question_35 {
}
class LRUCache {
    private final int capacity;
    private final Map<Integer,Integer> cache = new LinkedHashMap<>();// 自带双向链表

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 判断是否在链表中存在，存在就拿出来删除，再重新插入（重新插入最新）
        Integer value = cache.remove(key);
        if(value != null){
            cache.put(key,value);
            return value;
        }
        // key不在，返回-1
        return -1;
    }

    public void put(int key, int value) {
        // 判断是否在链表中存在，存在就拿出来删除，再重新插入（重新插入最新）
        Integer v = cache.remove(key);
        if(v != null){ // 在链表中存在，直接删除并重新插入
            cache.put(key,value);
            return;
        }
        // 如果链表中不存在，，那么就把 key 插入 cache，插入前判断 cache 是否满了
        if(cache.size() == capacity){ // cache满了
            // 1.	cache.keySet()：获取 cache 中所有的键，返回一个包含这些键的 Set。
            // 2.	iterator()：对 keySet 创建一个迭代器，用于遍历这些键。
            // 3.	next()：使用迭代器的 next() 方法获取集合中的第一个键。
            Integer oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key,value);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */