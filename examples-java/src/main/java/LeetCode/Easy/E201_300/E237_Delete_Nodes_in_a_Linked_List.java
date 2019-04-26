package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.ListNode;

/**
 * Write a function to delete a node (except the tail)
 * in a singly linked list, given only access to that node.
 * https://leetcode.com/problems/delete-node-in-a-linked-list/solution/
 * Created by liuxiang on 2018/10/28.
 */
public class E237_Delete_Nodes_in_a_Linked_List {
    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        ListNode n1 = new ListNode(5);
//        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(9);
//        head.next = n1;
//        n1.next = n2;
//        n2.next = n3;
//
//        Utils.printLinkedList(head);
//        deleteNode(n3);
//        Utils.printLinkedList(head);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
