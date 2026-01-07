package org.example.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int n1 = 3;
        System.out.println("Input: n = " + n1);
        List<String> result1 = solution.generateParenthesis(n1);
        System.out.println("Output: " + result1);

        System.out.println("---");

        // Example 2
        int n2 = 1;
        System.out.println("Input: n = " + n2);
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println("Output: " + result2);
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start with 0 open and 0 close parentheses
        recursive(result, n, new StringBuilder(), 0, 0);
        return result;
    }

    // Updated signature to track open and close counts
    public void recursive(List<String> result, int n, StringBuilder current, int open, int close) {

        // Base case: string length equals 2 * n
        if (current.length() == n * 2) {
            result.add(current.toString());
            return;
        }

        // Branch 1: Add open parenthesis if we haven't used all n
        if (open < n) {
            current.append('(');
            recursive(result, n, current, open + 1, close);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Branch 2: Add close parenthesis only if we have more open than close
        if (close < open) {
            current.append(')');
            recursive(result, n, current, open, close + 1);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}