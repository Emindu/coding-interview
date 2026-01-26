package org.example.string;

public class ReverseWordsInString {

    // =========================================================
    // Initial Solution (clear & straightforward)
    // Time: TBD
    // Space: TBD
    // =========================================================
    public static String reverseWordsInitial(String s) {
        // TODO: implement initial solution

        char[] charArray = s.toCharArray();
        reverse(charArray, 0, (charArray.length -1));
        int startSub = 0;
        int endSub = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ' ) {
                reverse(charArray, startSub, endSub - 1);
                startSub = i + 1;
            } else if (i == charArray.length -1 ) {
                reverse(charArray, startSub, endSub );
            }
            endSub++;

        }



        return new String(charArray).trim();
    }

    public static void reverse (char[] s, int start, int end){
        int left = start;
        int right = end;

        while (left < right){

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    // =========================================================
    // Optimized Solution (follow-up: O(1) extra space mindset)
    // Time: TBD
    // Space: TBD
    // =========================================================
    public static String reverseWordsOptimized(String s) {
        char[] arr = s.toCharArray();

        // 1) Reverse the whole array
        reverse(arr, 0, arr.length - 1);

        int n = arr.length;
        int i = 0;
        int write = 0; // index to write cleaned characters

        while (i < n) {
            // 2) Skip spaces
            while (i < n && arr[i] == ' ') {
                i++;
            }

            if (i >= n) break;

            // Add space before word (except first)
            if (write > 0) {
                arr[write++] = ' ';
            }

            // 3) Copy the word
            int wordStart = write;
            while (i < n && arr[i] != ' ') {
                arr[write++] = arr[i++];
            }

            // 4) Reverse the copied word
            reverse(arr, wordStart, write - 1);
        }

        return new String(arr, 0, write);
    }

    // =========================================================
    // Test Harness
    // =========================================================
    public static void main(String[] args) {
//        runTest("the sky is blue", "blue is sky the");
        runTest("  hello world  ", "world hello");
        runTest("a good   example", "example good a");
        runTest("one", "one");
        runTest("   multiple     spaces   here   ", "here spaces multiple");
    }

    private static void runTest(String input, String expected) {
        String result1 = reverseWordsInitial(input);
        String result2 = reverseWordsOptimized(input);

        System.out.println("Input    : \"" + input + "\"");
        System.out.println("Expected : \"" + expected + "\"");
        System.out.println("Initial  : \"" + result1 + "\"");
        System.out.println("Optimized: \"" + result2 + "\"");
        System.out.println("-----------------------------------");
    }
}
