import java.util.LinkedHashMap;

public class LRUCache {

    LinkedHashMap<Integer, Integer> cache;
    Integer capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(Integer key) {
        if (this.cache.containsKey(key)) {
            Integer value = this.cache.get(key);
            this.cache.remove(key);
            this.cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void set(Integer key, Integer value) {
        if (this.cache.containsKey(key)) {
            this.cache.remove(key);
            this.cache.put(key, value);
        } else {
            if (this.cache.size() >= this.capacity) {
                Integer old_key = this.cache.keySet().iterator().next();
                this.cache.remove(old_key);
            }
            this.cache.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        lru.set(2, 1);
        System.out.println(lru.get(2));
    }
}