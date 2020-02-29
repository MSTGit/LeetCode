package com.xd;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' ||c == '{' ||c == '[' ) {//左边部分的括号
                //入栈
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                //右边部分
                Character topChar = stack.pop();//把栈顶的元素弹出
                if (topChar == '(' && c != ')') return false;
                if (topChar == '{' && c != '}') return false;
                if (topChar == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }
}
