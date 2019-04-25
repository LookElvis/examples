package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.ListNode;
import LeetCode.PublicClass.Utils;

/**
 * Reverse a singly linked list.
 * https://leetcode.com/problems/reverse-linked-list/solution/
 * Created by liuxiang on 2018/10/24.
 */
public class E206_Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode result = reverseList(head);
        Utils.printLinkedList(result);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
