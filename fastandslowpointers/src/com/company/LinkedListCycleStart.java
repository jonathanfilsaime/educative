package com.company;

import java.util.HashMap;
import java.util.Map;

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        ListNode current = head;
        frequencyMap.put(current.value, frequencyMap.getOrDefault(current.value, 0) + 1);
        while (frequencyMap.getOrDefault(current.value, 0) <= 1 && current != null && current.next != null) {
            current = current.next;
            frequencyMap.put(current.value, frequencyMap.getOrDefault(current.value, 0) + 1);
        }
        head = current;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
