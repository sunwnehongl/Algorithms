package com.sun.link;

import java.util.Objects;
import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<Integer> stack = new Stack<>();
        while (slow != null) {
            stack.add(slow.val);
            slow = slow.next;
        }
        ListNode node = head;
        while (!stack.isEmpty()) {
            if (stack.pop() != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode v4 = new ListNode(1);
        ListNode v3 = new ListNode(2, v4);
        ListNode v2 = new ListNode(2);
        ListNode head = new ListNode(1, v2);
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(head));
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


