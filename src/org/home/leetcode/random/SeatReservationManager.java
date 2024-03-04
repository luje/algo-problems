package org.home.leetcode.random;

import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/seat-reservation-manager/description/
public class SeatReservationManager {


    static class SeatManager {

        final int n;

        final Queue<Integer> pq = new PriorityQueue<>();

        int counter = 1;

        public SeatManager(int n) {
            this.n = n;
        }

        public int reserve() {
            if(pq.isEmpty()) {
                return counter++;
            }

            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.offer(seatNumber);
        }
    }

    public static void main(String[] args) {
        var seatManager = new SeatManager(5);

        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
    }
}
