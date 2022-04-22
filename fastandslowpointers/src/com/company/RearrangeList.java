package com.company;

import java.util.Stack;

public class RearrangeList {

    public static void reorder(ListNode head) {
        // TODO: Write your code here
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode copyHead = head;
        Stack<Integer> theStack = new Stack<>();

        //reverse order of second half
        while(slow != null) {
            theStack.push(slow.value);
            slow = slow.next;
        }

        int count = 1;
        ListNode temp = null;
        while(!theStack.empty()) {
            if(count % 2 == 0) {
                head = new ListNode(theStack.pop());
                System.out.println("count % 2 == 0 head address: " + head);
                System.out.println("count % 2 == 0 head.value: " + head.value);
            } else {
                if(count == 1) {
                    head = new ListNode(copyHead.value);
                    temp = head;
                    System.out.println("else count == 1 temp address: " + temp);
                    System.out.println("else count == 1 temp.value: " + temp.value);
                } else {
                    head.value = copyHead.value;
                }
                System.out.println("else head address: " + head);
                System.out.println("else head.value: " + head.value);
                copyHead = copyHead.next;
            }
            count++;
            if (!theStack.empty()) {
                head.next = new ListNode(0);
                head = head.next;
            }
        }
        head = temp;
        System.out.println("temp -> : " + temp);
        System.out.println("head -> : " + head);
        while(head != null) {
            System.out.println("final value :" + head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        System.out.println("address of head before ---> " + head);
        RearrangeList.reorder(head);
        System.out.println("address of head after ---> " + head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}

//class RearrangeList {
//
//    public static void reorder(ListNode head) {
//        if (head == null || head.next == null)
//            return;
//
//        // find the middle of the LinkedList
//        ListNode slow = head, fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        // slow is now pointing to the middle node
//        ListNode headSecondHalf = reverse(slow); // reverse the second half
//        ListNode headFirstHalf = head;
//
//        // rearrange to produce the LinkedList in the required order
//        while (headFirstHalf != null && headSecondHalf != null) {
//            ListNode temp = headFirstHalf.next;
//            headFirstHalf.next = headSecondHalf;
//            headFirstHalf = temp;
//
//            temp = headSecondHalf.next;
//            headSecondHalf.next = headFirstHalf;
//            headSecondHalf = temp;
//        }
//
//        // set the next of the last node to 'null'
//        if (headFirstHalf != null)
//            headFirstHalf.next = null;
//    }
//
//    private static ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = prev;
//            prev = head;
//            head = next;
//        }
//        return prev;
//    }
//
//    public static void main(String[] args) {
//        ListNode head = new ListNode(2);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(6);
//        head.next.next.next = new ListNode(8);
//        head.next.next.next.next = new ListNode(10);
//        head.next.next.next.next.next = new ListNode(12);
//        RearrangeList.reorder(head);
//        while (head != null) {
//            System.out.print(head.value + " ");
//            head = head.next;
//        }
//    }
//}
//

