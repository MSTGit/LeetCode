package com.xd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String currentChar = tokens[i];
            if (currentChar.equals("+")){
                Integer second = numStack.pop();
                Integer first = numStack.pop();
                numStack.push(second + first);
            } else if (currentChar.equals("-")) {
                Integer second = numStack.pop();
                Integer first = numStack.pop();
                numStack.push(first - second);
            } else if (currentChar.equals("*")) {
                Integer second = numStack.pop();
                Integer first = numStack.pop();
                numStack.push(second * first);
            } else if (currentChar.equals("/")) {
                Integer second = numStack.pop();
                Integer first = numStack.pop();
                numStack.push(first / second);
            } else {
                numStack.push(Integer.parseInt(currentChar));
            }
        }
        return numStack.peek();
    }
}

