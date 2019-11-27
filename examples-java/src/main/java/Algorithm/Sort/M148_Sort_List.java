package Algorithm.Sort;

import LeetCode.PublicClass.ListNode;
import LeetCode.PublicClass.Utils;

/**
 * Created by Elvis on 2019/11/27.
 */
public class M148_Sort_List {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = sortList(n1);
        Utils.printLinkedList(result);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(-1);
        h.next = head;

        ListNode pre = h;
        ListNode cur = h;

        while (cur.next != null) {
            ListNode t = cur.next;
            int min = t.val;
            while (t.next != null) {
                if (t.next.val <= min) {
                    min = t.next.val;
                    pre = t;
                }
                t = t.next;
            }
            t = pre.next;

            pre.next = t.next;
            t.next = cur.next;
            cur.next = t;
//            System.out.println(min);
//
//            Utils.printLinkedList(h);

            cur = cur.next;
            pre = cur;
        }

        return h.next;
    }
}
