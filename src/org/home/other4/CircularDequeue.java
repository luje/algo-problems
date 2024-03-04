package org.home.other4;

public class CircularDequeue {

    static class MyCircularDeque {

        final int k;

        int capacity;

        Node first;
        Node last;

        public MyCircularDeque(int k) {
            this.k = k;
        }

        public boolean insertFront(int value) {
            if (capacity == k) return false;

            capacity++;

            final var target = new Node();
            target.value = value;

            if (first != null) {
                target.next = first;
                first.prev = target;
            }

            first = target;

            return true;
        }

        public boolean insertLast(int value) {
            if (capacity == k) return false;

            capacity++;

            final var target = new Node();
            target.value = value;

            if (last != null) {
                target.prev = last;
                last.next = target;
            }

            last = target;

            return true;
        }

        public boolean deleteFront() {
            if (capacity == 0)
                return false;

            capacity--;
            first = first.next;

            if(capacity == 0) {
                first = null;
                last = null;
            }

            return true;
        }

        public boolean deleteLast() {
            if (capacity == 0)
                return false;

            capacity--;
            last = last.prev;

            if(capacity == 0) {
                first = null;
                last = null;
            }

            return true;
        }

        public int getFront() {
            return first.value;
        }

        public int getRear() {
            return last.value;
        }

        public boolean isEmpty() {
            return capacity == 0;
        }

        public boolean isFull() {
            return capacity == k;
        }

        static class Node {

            int value;

            Node prev;
            Node next;
        }
    }

    public static void main(String[] args) {


//          Your MyCircularDeque object will be instantiated and called as such:
//        int k = 3;

        MyCircularDeque myCircularDeque = new MyCircularDeque(3);

        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }


}
