package LeetCode.Easy.E001_100;

import LeetCode.PublicClass.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * https://leetcode.com/submissions/detail/177429023/
 * Created by liuxiang on 2018/9/20.
 */
public class E021_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(11);
        l1.next = node1;
        node1.next = node2;

        ListNode l2 = new ListNode(2);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(10);
        l2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode mergeTwoLists = mergeTwoLists(l1, l2);

        while (mergeTwoLists != null) {
            System.out.print(mergeTwoLists.val + "->");
            mergeTwoLists =  mergeTwoLists.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode node;
        node = listNode;

        if(l1 == null && l2 == null) {
            return null;
        }

        while (l1 != null || l2 != null) {
            if(l1 == null) {
                listNode.next = l2;
                l2 = l2.next;
                break;
            }

            if(l2 == null) {
                listNode.next = l1;
                l1 = l1.next;
                break;
            }

            if(l1.val <= l2.val) {
                listNode.next = l1;
                listNode = listNode.next;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                listNode = listNode.next;
                l2 = l2.next;
            }
        }

        return node.next;
    }
}
