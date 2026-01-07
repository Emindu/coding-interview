package org.example.string;


import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(String s, String t) {
        // TODO: Implement your solution here

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
            count[t.charAt(i) - 'a'] -= 1;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // ==================== TEST HARNESS ====================

    public static void main(String[] args) {
        Anagram solution = new Anagram();

        // Test Case 1
        test(solution, "anagram", "nagaram", true, "Basic anagram");

        // Test Case 2
        test(solution, "rat", "car", false, "Not an anagram");

        // Test Case 3
        test(solution, "a", "a", true, "Single character - same");

        // Test Case 4
        test(solution, "a", "b", false, "Single character - different");

        // Test Case 5
        test(solution, "ab", "a", false, "Different lengths");

        // Test Case 6
        test(solution, "", "", true, "Empty strings");

        // Test Case 7
        test(solution, "aab", "aba", true, "Repeated characters");

        // Test Case 8
        test(solution, "aacc", "ccac", false, "Same chars, different counts");

        // Test Case 9
        test(solution, "ggii", "eekk", false, "Same chars, different counts");


        System.out.println("\n✅ All tests completed!");
    }

    private static void test(Anagram sol, String s, String t, boolean expected, String testName) {
        boolean result = sol.isAnagram(s, t);
        String status = result == expected ? "PASS ✓" : "FAIL ✗";
        System.out.printf("[%s] %s: isAnagram(\"%s\", \"%s\") = %b (expected: %b)%n",
                status, testName, s, t, result, expected);
    }
}