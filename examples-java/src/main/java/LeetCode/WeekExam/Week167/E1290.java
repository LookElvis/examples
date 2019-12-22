package LeetCode.WeekExam.Week167;

import LeetCode.PublicClass.ListNode;

/**
 * Created by Elvis on 2019/12/15.
 */
public class E1290 {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        ListNode q = head;
        long mul = 1;
        int count = 0;
        while (p != null) {
            p = p.next;
            mul <<= 1;
        }
        while (q != null) {
            if (q.val == 1) {
                count += (mul >> 1);
            }
            q = q.next;
            mul >>= 1;
        }
        return count;
    }
}
