package org.home.other3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

class LRUCache {

    final Map<Integer, Integer> values;
    final LinkedList<Integer> priorities;
    final int capacity;

    public LRUCache(int capacity) {
        this.values = new HashMap<>(capacity);
        this.priorities = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        update(key);

        return values.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        update(key);

        values.put(key, value);
    }

    private void update(int key) {
        if(!values.containsKey(key))
            return;

        if (priorities.size() > 0) {
            priorities.remove((Object) key);
        }

        priorities.push(key);

        if (priorities.size() > capacity) {
            final Integer val = priorities.removeLast();

            values.remove(val);
        }

        System.out.println(values.entrySet()
                .stream()
                .map(it -> "(" + it.getKey() + " -> " + it.getValue() + ")")
                .collect(Collectors.joining(" ")));

        System.out.println(priorities.stream()
                .map(it -> it.toString())
                .collect(Collectors.joining(" ")));

        System.out.println("----------------");
    }

    public static void main(String[] args) {
        final LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
