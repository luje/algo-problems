package neetcode150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
public class CountOfSmallerNumbersThanSelf {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int[] heap = new int[nums.length + 8];
        int size = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            insert(nums[i], heap, size++);

            result.add(count(nums[i], heap, 0, size - 1));
        }

        Collections.reverse(result);

        return result;
    }

    private int count(int num, int[] heap, int root, int size) {
        if (root >= size) {
            return 0;
        }

        if (heap[root] >= num) {
            return 0;
        }

        return 1 + count(num, heap, left(root), size) + count(num, heap, right(root), size);
    }

    public void insert(int v, int[] heap, int last) {
        heap[last] = v;

        int current = last;
        while (heap[current] < heap[parent(current)]) {
            int parent = parent(current);

            int aux = heap[current];
            heap[current] = heap[parent];
            heap[parent] = aux;

            current = parent(current);
        }
    }

    public int parent(int c) {
        return (c - 1) / 2;
    }

    public int left(int c) {
        return c * 2 + 1;
    }

    public int right(int c) {
        return c * 2 + 2;
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersThanSelf solver = new CountOfSmallerNumbersThanSelf();

        System.out.println(solver.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
