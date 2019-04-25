package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.ListNode;
import LeetCode.PublicClass.Utils;

/**
 * Remove all elements from a linked list of integers that have value.
 * https://leetcode.com/submissions/detail/184477461/
 * Created by liuxiang on 2018/10/22.
 */
public class E203_Remove_Linked_List_Elements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        int val = 6;
        ListNode result = removeElements(head, val);
        Utils.printLinkedList(result);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        result.next = head;
        while (head != null) {
            if (head.val == val) {
                temp.next = head.next;
            } else {
                temp = temp.next;
            }
            head = head.next;
        }
        return result.next;
    }
}
