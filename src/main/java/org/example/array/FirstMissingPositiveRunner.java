package org.example.array;
import java.util.Arrays;
import java.util.HashSet;

public class FirstMissingPositiveRunner {

    /**
     * TODO: Implement the algorithm here.
     * Constraints: O(n) time and O(1) auxiliary space.
     */
    public int firstMissingPositive(int[] nums) {
        // Your code goes here

        HashSet<Integer> integers = new HashSet<>();

        for (int num : nums) {
            integers.add(num);
        }

        int result = 0;
        int count = 1;

        while(true){

            if (integers.contains(count)){
                count ++;
            } else {
                result = count;
                break;
            }


        }


        return result; // Placeholder return
    }

    // --- Driver Code for Local Testing ---
    public static void main(String[] args) {
        FirstMissingPositiveRunner solver = new FirstMissingPositiveRunner();

        // Test Case 1
        int[] input1 = {1, 2, 0};
        runTestCase(solver, input1, 3, 1);

        // Test Case 2
        int[] input2 = {3, 4, -1, 1};
        runTestCase(solver, input2, 2, 2);

        // Test Case 3
        int[] input3 = {7, 8, 9, 11, 12};
        runTestCase(solver, input3, 1, 3);

        // You can add more custom test cases here
    }

    private static void runTestCase(FirstMissingPositiveRunner solver, int[] nums, int expected, int testId) {
        // Copy array to avoid modifying the original during print (if logic sorts in-place)
        int[] originalInput = Arrays.copyOf(nums, nums.length);

        System.out.println("--------------------------------------------------");
        System.out.println("Test Case " + testId);
        System.out.println("Input: " + Arrays.toString(originalInput));

        long startTime = System.nanoTime();
        int result = solver.firstMissingPositive(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);

        if (result == expected) {
            System.out.println("Result: ✅ PASSED");
        } else {
            System.out.println("Result: ❌ FAILED");
        }
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}