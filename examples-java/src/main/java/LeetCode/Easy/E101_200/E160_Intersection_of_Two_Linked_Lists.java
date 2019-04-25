package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * https://leetcode.com/submissions/detail/183301496/
 * Created by liuxiang on 2018/10/17.
 */
public class E160_Intersection_of_Two_Linked_Lists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);//insert node
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(7);

        ListNode head2 = new ListNode(2);
        ListNode n6 = new ListNode(8);
        ListNode n7 = new ListNode(9);

        head1.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        head2.next = n6;
        n6.next = n7;
        n7.next = n3;

        ListNode result = getIntersectionNode(head1, head2);
        System.out.println(result.val);
//        Utils.printLinkedList(head1);
//        System.out.println();
//        Utils.printLinkedList(head2);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode countA = headA;
        ListNode countB = headB;

        while (countA != null) {
            lengthA++;
            countA = countA.next;
        }

        while (countB != null) {
            lengthB++;
            countB = countB.next;
        }

        if (lengthA <= lengthB) {
            return helper(headA, headB, lengthB - lengthA);
        } else {
            return helper(headB, headA, lengthA - lengthB);
        }
    }

    public static ListNode helper(ListNode headS, ListNode headL, int minu) {
        for (int i = 0; i < minu; i++) {
            headL = headL.next;
        }

        while (headL != null) {
            if (headS == headL) {
                return headL;
            }
            headS = headS.next;
            headL = headL.next;
        }
        return null;
    }
}
