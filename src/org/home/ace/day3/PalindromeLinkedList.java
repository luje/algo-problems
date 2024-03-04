package org.home.ace.day3;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        int n = 0;

        while (current != null) {
            current = current.next;
            n++;
        }

        return true;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
