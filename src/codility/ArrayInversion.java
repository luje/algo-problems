package codility;

import java.util.ArrayList;
import java.util.List;

public class ArrayInversion {

    public int solution(int[] A) {
        // Implement your solution here
        int count = 0;
        List<Integer> prev = new ArrayList<>(A.length);

        for (int d : A) {
            final var index = bs(prev, d, 0, prev.size());

            count += prev.size() - index;
            prev.add(index, d);
        }

        return count;
    }

    public int bs(List<Integer> a, int value, int start, int end) {
        if(start >= end) {
            return start;
        }

        int mid = start + (end - start) / 2;

        if(value < a.get(mid)) {
            return bs(a, value, start, mid);
        } else {
            return bs(a, value, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        var solver = new ArrayInversion();

        System.out.println(solver.solution(new int[]{}));
        System.out.println(solver.solution(new int[]{-1, 6, 3, 4, 7, 4}));
        System.out.println(solver.solution(new int[]{3, 2, 1}));
        System.out.println(solver.solution(new int[]{1, 2, 3}));
        System.out.println(solver.solution(new int[]{1, 1, 1}));

        System.out.println("---------------");
        System.out.println(solver.bs(List.of(), 2, 0, 0));
        System.out.println(solver.bs(List.of(1, 2, 3), 2, 0, 3));
        System.out.println(solver.bs(List.of(1, 2, 3), 4, 0, 3));
        System.out.println(solver.bs(List.of(1, 2, 2, 2, 2, 3, 3, 3), 2, 0, 8));
        System.out.println(solver.bs(List.of(1, 2, 4), 3, 0, 3));
        System.out.println(solver.bs(List.of(1, 2), 1, 0, 2));
        System.out.println(solver.bs(List.of(1), 1, 0, 1));
        System.out.println(solver.bs(List.of(1, 2, 2, 2, 2), 2, 0, 5));
    }
}
