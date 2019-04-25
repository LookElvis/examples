package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * https://leetcode.com/submissions/detail/185581636/
 * Created by liuxiang on 2018/10/27.
 */
public class E234_Palindrome_Linked_List {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        node.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        boolean result = isPalindrome(node);
        System.out.println(result);
    }

    public static ListNode listNode;
    public static boolean isPalindrome(ListNode head) {
        listNode = head;
        return helper(head);
    }

    public static boolean helper(ListNode head) {
        if (head == null) {
            return true;
        }

        boolean tail = helper(head.next);
        boolean isEqual = (listNode.val == head.val) ? true : false;
        listNode = listNode.next;
        return tail && isEqual;
    }
}
