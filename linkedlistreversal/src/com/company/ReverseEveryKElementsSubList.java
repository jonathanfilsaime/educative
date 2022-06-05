package com.company;

public class ReverseEveryKElementsSubList {

    public static ListNode reverse(ListNode head, int k) {
        if(head == null && k <= 1) return head;

        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = null;
            ListNode firstNodeBeforeSwap = current;
            ListNode firstNodeNotSwap = prev;
            for(int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            if(firstNodeNotSwap == null) {
                head = prev;
            } else {
                firstNodeNotSwap.next = prev;
            }

            firstNodeBeforeSwap.next = current;

            for(int i = 0; current != null && i < k; ++i) {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElementsSubList.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}