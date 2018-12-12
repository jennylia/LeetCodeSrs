package com.company.hard;

import java.util.ArrayList;
import java.util.List;

public class Q32_LongestValidParen {

    //    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
    public static void main(String[] args) {
        // edge test case
        List<String> inputs = new ArrayList<>();
        inputs.add("()(())");
        inputs.add("(()())");
        inputs.add("())))))))))))))))))))");


//        inputs.add(")()())");
//        inputs.add(")()");
//        inputs.add(")()())()()(");
//        inputs.add("()");

        for (String s : inputs) {
            int ans = longestValidParenthesesMyTry(s);
            System.out.println(s + ":" + ans);
        }
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }

        return maxans;
    }

    public static int longestValidParenthesesMyTry(String s) {
        int[] dp = new int[s.length()];
        int maxAns = 0;
        int i = 0;

        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.charAt(0) == ')') {
            i++;
        }

        for (; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // is previous charactor a ')'
                int prevIndex = i - 1;
                if (s.charAt(prevIndex) == '(') {
                    System.out.println("I have case 1():" + i);
                    if (i > 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                    maxAns = Math.max(maxAns, dp[i]);

                } else if (s.charAt(prevIndex) == ')') {
                    System.out.println("I have case 2()):" + i);
                    //i'm completing my substring

                    int startingIndex = i - dp[i - 1] - 1;
                    if (startingIndex >= 0 && s.charAt(startingIndex) == '(') {
                        // I need the result from the substring from before my completion
                        int prevSlot = dp[i - 1];

                        // before substring
                        int previousCache = 0;
                        if (startingIndex > 1) {
                            previousCache = dp[startingIndex-1];
                        }
                        dp[i] = prevSlot + previousCache + 2; // 2 pieces}
                    }
                    maxAns = Math.max(maxAns, dp[i]);

                }
            }

        }
        return maxAns;
    }

    public static int longestValidParenthesesBF(String s) {
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
