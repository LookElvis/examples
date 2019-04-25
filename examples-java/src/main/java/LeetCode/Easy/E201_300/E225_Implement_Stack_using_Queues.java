package LeetCode.Easy.E201_300;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implement the following operations of a stack using queues.
 * https://leetcode.com/submissions/detail/185122874/
 * Created by liuxiang on 2018/10/25.
 */
public class E225_Implement_Stack_using_Queues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }

    static class MyStack {
        Deque<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            this.queue = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            this.queue.push(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return this.queue.pop();
        }

        /** Get the top element. */
        public int top() {
            return this.queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

}
