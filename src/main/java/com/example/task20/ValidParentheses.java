package com.example.task20;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([])"
 * Output: true
 *
 * Example 5:
 * Input: s = "([)]"
 * Output: false
 */

// use stack
public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char currentChar;
        char topDeck;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
                continue;
            }
            if (currentChar == '}' || currentChar == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                topDeck = stack.peek();
                if (((int)currentChar - 2) == (int)topDeck) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (currentChar == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                topDeck = stack.peek();
                if (topDeck == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    // Оставлю это здесь, как упоминание лучшей версии
    public boolean isValidBetter(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.isEmpty()) {
                char last = stack.peek();
                if (isPair(last, cur)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);
        }

        return stack.isEmpty();
    }

    private boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') ||
                (last == '{' && cur == '}') ||
                (last == '[' && cur == ']');
    }
}