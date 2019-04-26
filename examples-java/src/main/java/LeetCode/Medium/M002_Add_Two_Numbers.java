package LeetCode.Medium;

import LeetCode.PublicClass.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers
 * Add the two numbers and return it as a linked list.
 * https://leetcode.com/problems/add-two-numbers/solution/
 *
 * Created by liuxiang on 2018/9/21.
 */
public class M002_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1); //9342+863=
        l1.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(9);
        l2.next = node4;
        node4.next = node5;
        node5.next = node6;   //9863+342

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + "->");
            result =  result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        boolean isAdd = false;
        int temp = 0;
        while (l1 != null && l2 != null) {
            if(isAdd) {
                temp = l1.val + l2.val + 1;
                isAdd = false;
            } else {
                temp = l1.val + l2.val;
            }

            if(temp >= 10) {
                isAdd = true;
            }
            l1.val = temp % 10;
            node.next = l1;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while ((l1 != null)) {
            if(isAdd) {
                temp = l1.val + 1;
                isAdd = false;
            } else {
                temp = l1.val;
            }
            if(temp >= 10) {
                isAdd = true;
            }
            l1.val = temp % 10;
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }

        while ((l2 != null)) {
            if(isAdd) {
                temp = l2.val + 1;
                isAdd = false;
            } else {
                temp = l2.val;
            }
            if(temp >= 10) {
                isAdd = true;
            }
            l2.val = temp % 10;
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }

        if (isAdd) {
            node.next = new ListNode(1);
        }
        return listNode.next;
    }
}