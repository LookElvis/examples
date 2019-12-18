package Algorithm.Problem;

import LeetCode.PublicClass.ListNode;
import LeetCode.PublicClass.Utils;

/**
 * Created by Elvis on 2019/12/18.
 */
public class P3_3 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        h.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(isPalindrome(h));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //设置快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse后半部分
        ListNode p = slow.next;
        slow.next = null;
        ListNode t = slow;
        ListNode h = p;
        while (h != null) {
            h = h.next;
            p.next = t;
            t = p;
            p = h;
        }
//        Utils.printLinkedList(head);
//        Utils.printLinkedList(t);
        //判断是否是回文
        boolean res = true;
        ListNode pre = head;
        ListNode suf = t;
        while (t != null && head != null) {
            if (t.val != head.val) {
                res = false;
                break;
            }
            t = t.next;
            head = head.next;
        }
        //还原数组
        Utils.printLinkedList(pre);
        Utils.printLinkedList(suf);
        h = suf;
        p = h;
        ListNode t1 = null;
        while (h != null) {
            h = h.next;
            p.next = t1;
            t1= p;
            p = h;
        }
        if (t == null) {
            t = h;
        } else {
            t.next = h;
        }
        Utils.printLinkedList(pre);
        return res;
    }
}
