package com.company.hard;

import java.util.ArrayList;
import java.util.List;

public class Q32_LongestValidParen {

    //    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
    public static void main(String[] args) {
        // edge test case
//        int ans =
        List<String> inputs = new ArrayList<>();
        inputs.add(")()())");
        inputs.add(")()");
        inputs.add(")()())()()(");
        inputs.add("()");

        for (String s : inputs) {
            int ans = longestValidParentheses(s);
            System.out.println(s + ":" + ans);
        }
    }

    public static int longestValidParentheses(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            String toValidate = s.substring(i);
            int longestSeen = longestValidParenthesesHelper(toValidate);
            if (longestSeen > longest)
                longest = longestSeen;
        }
        return longest;

    }

    public static int longestValidParenthesesHelper(String s) {
        int longest = 0;
        char leftParen = '(';
        char rightParen = ')';

        int leftCount = 0;
        int rightCount = 0;

        // Todo, validate for right paren....
        if (s == null || s.isEmpty()) {
            return longest;
        }

        if (s.charAt(0) == rightParen) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == leftParen) {
                leftCount++;
            } else {
                rightCount++;
            }

            int currentValidLength = validate(leftCount, rightCount);
//            invalid, must discontinue
            if (currentValidLength < 0) {
                return longest;
            }
            if (currentValidLength > longest) {
                longest = currentValidLength;
            }
        }
        return longest;
    }

    private static int validate(int leftCount, int rightCount) {
        if (rightCount == leftCount) {
            return leftCount + rightCount;
        }
        if (rightCount > leftCount) {
            return -1;
        }
        return 0;
    }

}
