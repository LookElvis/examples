package Common.AlgrithmTest;

import PublicClass.Utils;

import java.util.Stack;

/**
 * 单调栈
 * Created by Elvis on 2020/4/11.
 */
public class SingleStack {
    public static void main(String[] args) {
        SingleStack singleStack = new SingleStack();
        int[] arr = new int[]{2,1,2,4,3};
        int[] res = singleStack.nextGreaterElement(arr);
        Utils.printIntArrays(res);
    }

    public int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
