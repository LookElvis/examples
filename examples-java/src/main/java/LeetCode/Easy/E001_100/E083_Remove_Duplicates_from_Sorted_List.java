package LeetCode.Easy.E001_100;

import LeetCode.PublicClass.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * https://leetcode.com/articles/remove-duplicates-from-sorted-list/
 * Created by liuxiang on 2018/9/25.
 */
public class E083_Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);

        listNode.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode result = deleteDuplicates(listNode);
        while (result != null) {
            System.out.print(result.val + "->");
            result =  result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = new ListNode(0);
        ListNode temp;
        listNode.next = head;
        Map map = new HashMap();
        while (listNode.next != null) {
            if(!map.containsKey(listNode.next.val)) {
                map.put(listNode.next.val, "");
                listNode = listNode.next;
            } else {
                temp = listNode.next;
                listNode.next = temp.next;
            }
        }
        return head;
    }
}
