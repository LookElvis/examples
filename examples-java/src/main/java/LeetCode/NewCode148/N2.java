package LeetCode.NewCode148;

import java.util.Stack;

/**
 * Created by Elvis on 2020/1/14.
 */
public class N2 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = operate(op1, op2, tokens[i]);
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    public int operate(int op1, int op2, String operator) {
        if (operator.equals("+")) {
            return op1 + op2;
        } else if (operator.equals("-")) {
            return op1 - op2;
        } else if (operator.equals("*")) {
            return op1 * op2;
        } else {
            return op1 / op2;
        }
    }
}
