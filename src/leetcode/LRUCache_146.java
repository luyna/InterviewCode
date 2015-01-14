package leetcode;


import java.util.*;


public class LRUCache_146 {
	private int capacity;
	private LinkedHashMap<Integer,Integer> cache;
    public LRUCache_146(int capacity) {
        this.capacity=capacity;
        cache=new LinkedHashMap<Integer,Integer>();
    }
    /**
     * Get the value (will always be positive) of the key 
     * if the key exists in the cache, otherwise return -1.
     */
    public int get(int key) {
    	if(cache.containsKey(key)) return cache.get(key);
    	return -1;
    }
    /**
     *  Set or insert the value if the key is not already present. 
     *  When the cache reached its capacity, it should invalidate
     *   the least recently used item before inserting a new item.
     */
    public void set(int key, int value) {
        if(cache.containsKey(key)) cache.get(key);
        
    }
}

class CacheMap{
	private int key;
	private int value;
	public CacheMap(int key,int value){
		this.key=key;
		this.value=value;
	}
}
