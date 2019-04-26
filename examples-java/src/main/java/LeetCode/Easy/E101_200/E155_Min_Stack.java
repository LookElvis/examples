package LeetCode.Easy.E101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * https://leetcode.com/submissions/detail/183116318/
 * Created by liuxiang on 2018/10/16.
 */
public class E155_Min_Stack {
    public static void main(String[] args) {
        E155_Min_Stack obj = new E155_Min_Stack();
        obj.push(6);
        obj.push(4);
        obj.push(5);
        obj.push(2);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }

    private int top;
    private int bottom;
    private List<Integer> list;

    public E155_Min_Stack() {
        this.list = new ArrayList<>();
        this.top = -1;
        this.bottom = -1;
    }

    public void push(int x) {
        this.list.add(x);
        this.top++;
    }

    public void pop() {
        if (this.top != this.bottom) {
            this.list.remove(top);
            this.top--;
        }
    }

    public int top() {
        if (this.top != this.bottom) {
            return this.list.get(this.top);
        }
       return 0;
    }

    public int getMin() {
        if(this.top != this.bottom) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) < min) {
                    min = list.get(i);
                }
            }
            return min;
        }
        return 0;
    }
}
