package org.home.other3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    int size = 0;
    final Random r;

    final HashMap<Integer, Integer> byValue;
    final List<Integer> byKey;

    public RandomizedSet() {
        byValue = new HashMap<>();
        byKey = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (byValue.containsKey(val)) {
            return false;
        }

        byValue.put(val, size);
        byKey.add(val);

        size++;

        return true;
    }

    public boolean remove(int val) {
        if (!byValue.containsKey(val)) {
            return false;
        }

        int last = byKey.get(size - 1);
        int valKey = byValue.get(val);

        byValue.remove(last);
        byKey.remove(size - 1);

        byValue.remove(val);

        if (val != last) {
            byValue.put(last, valKey);
            byKey.set(valKey, last);
        }

        size--;

        return true;
    }

    public int getRandom() {
        return byKey.get(r.nextInt(size));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

//        System.out.println(randomizedSet.insert(1));
//        System.out.println(randomizedSet.remove(2));
//        System.out.println(randomizedSet.insert(2));
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.remove(1));
//        System.out.println(randomizedSet.insert(2));
//        System.out.println(randomizedSet.getRandom());

        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
    }
}
