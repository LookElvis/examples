package Algorithm.Sort;


import LeetCode.PublicClass.ListNode;

/**
 * Created by Elvis on 2019/11/26.
 */
public class M147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode cur = head;
        ListNode pre = h;

        while (cur != null) {
            if (cur.next != null && cur.next.val < cur.val) {
                while (pre.next != null && pre.next.val < cur.next.val) {
                    pre = pre.next;
                }

                ListNode tmp = pre.next;
                ListNode t = cur.next;
                cur.next = t.next;
                pre.next = t;
                t.next = tmp;

                pre = h;
            } else {
                cur = cur.next;
            }
        }

        return h.next;
    }
}
