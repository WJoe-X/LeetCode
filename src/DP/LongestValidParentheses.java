package DP;

import java.util.List;
import java.util.Stack;

/**
 * @auther: WJoe
 * @Description: Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * @Date : 17:04 2018/8/10
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int[] ints = new int[s.length()];
        int i = 0;
        int max = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    int start = stack.pop();
                    ints[i] = i - start + 1;
                    if (start > 0)
                        ints[i] += ints[start - 1];
                    if (ints[i] > max)
                        max = ints[i];
                }
            }
            i++;
        }
        return max;
    }


    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("()(()"));
    }
}

