package com.company;

import java.util.*;

class RotateList {

    public static ListNode rotate(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0)
            return head;

        ListNode lastNode = head;
        int size = 1;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            size++;
        }

        lastNode.next = head;
        int mod = size % rotations;
        int skip = rotations - mod;
        ListNode afteSkip = head;
        for(int i = 0; i < skip - 1; i++) {
            afteSkip = afteSkip.next;
        }

        head = afteSkip.next;
        afteSkip.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}