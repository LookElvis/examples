package LeetCode.Easy.E201_300;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement the following operations of a queue using stacks.
 * https://leetcode.com/problems/implement-queue-using-stacks/solution/
 * Created by liuxiang on 2018/10/27.
 */
public class E232_Implement_Queue_using_Stacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }

    static class MyQueue {
        Deque<Integer> deque;

        /** Initialize your data structure here. */
        public MyQueue() {
            deque = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            deque.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return deque.pollLast();
        }

        /** Get the front element. */
        public int peek() {
            return deque.peekLast();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return deque.isEmpty();
        }
    }
}
