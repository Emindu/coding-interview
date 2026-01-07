package org.example.string;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // TODO: Implement your solution here


        String lowerCase = s.toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++) {

            if ((s.charAt(i)) != (s.charAt(s.length() - 1 - i))) {
                return false;

            }


        }

        return true;
    }

    // ==================== TEST HARNESS ====================

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // Test Case 1
        test(solution, "A man, a plan, a canal: Panama", true, "Classic palindrome with spaces and punctuation");

        // Test Case 2
        test(solution, "race a car", false, "Not a palindrome");

        // Test Case 3
        test(solution, " ", true, "Empty after removing non-alphanumeric");

        // Test Case 4
        test(solution, "a", true, "Single character");

        // Test Case 5
        test(solution, "ab", false, "Two different characters");

        // Test Case 6
        test(solution, "aa", true, "Two same characters");

        // Test Case 7
        test(solution, "Aa", true, "Case insensitive");

        // Test Case 8
        test(solution, "0P", false, "Alphanumeric mix - not palindrome");

        // Test Case 9
        test(solution, "a1b2b1a", true, "Alphanumeric palindrome");

        // Test Case 10
        test(solution, ".,", true, "Only non-alphanumeric chars");

        // Test Case 11
        test(solution, "No 'x' in Nixon", true, "Another classic palindrome");

        System.out.println("\n✅ All tests completed!");
    }

    private static void test(ValidPalindrome sol, String s, boolean expected, String testName) {
        boolean result = sol.isPalindrome(s);
        String status = result == expected ? "PASS ✓" : "FAIL ✗";
        System.out.printf("[%s] %s: isPalindrome(\"%s\") = %b (expected: %b)%n",
                status, testName, s, result, expected);
    }
}