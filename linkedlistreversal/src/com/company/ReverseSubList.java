package com.company;

import java.util.*;

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        // TODO: Write your code here
        if( p == q) return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        for(int i = 0; current != null && i < p -1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = prev;
        ListNode lastNodeOfTheSubList = current;

        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if(lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = prev;
        } else {
            head = prev;
        }

        lastNodeOfTheSubList.next = current;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}