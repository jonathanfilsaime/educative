package com.company;

import java.util.Stack;

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode copyHead = head;
        Stack<Integer> headStack = new Stack<>();
        while (copyHead != null) {
            headStack.push(copyHead.value);
            copyHead = copyHead.next;
        }

        while(head != null) {
            if(head.value != headStack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}