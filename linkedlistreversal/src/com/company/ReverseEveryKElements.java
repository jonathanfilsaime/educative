package com.company;

import java.util.*;

class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here
        if(head == null || k <= 1) return head;

        ListNode prev = null;
        ListNode current = head;


        while(true) {

            ListNode lastNodeOfPreviousPart = prev;
            ListNode lastNodeOfSubList = current;

            ListNode next = null;
            for(int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            if(lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = prev;
            } else {
                head = prev;
            }

            lastNodeOfSubList.next = current;

            if (current == null) // break, if we've reached the end of the LinkedList
                break;
            // prepare for the next sub-list
            prev = lastNodeOfSubList;
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

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}