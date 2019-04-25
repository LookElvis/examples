package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 * Created by liuxiang on 2018/10/16.
 */
public class E141_Linked_List_Cycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(6);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        boolean result = hasCycle(head);
        System.out.println(result);
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
