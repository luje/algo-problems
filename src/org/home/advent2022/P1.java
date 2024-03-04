package org.home.advent2022;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        long current = 0;

        final PriorityQueue<Long> pq = new PriorityQueue<>(4);

        while (input.hasNext()) {
            try {
                current += Long.valueOf(input.nextLine());
            } catch (NumberFormatException e) {
                pq.add(current);

                if(pq.size() > 3) {
                    pq.poll();
                }

                current = 0;
            }
        }

        System.out.println(pq.stream().mapToLong(it -> it).sum());
    }
}
