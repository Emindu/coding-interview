package org.example.array;
import java.util.Arrays;

public class MaxSubarraySolution {

    /**
     * TODO: Implement your solution here.
     * * Given an integer array nums, find the subarray with the largest sum,
     * and return its sum.
     */
    public int maxSubArray(int[] nums) {
// 1. Initialize max to the first element (handles negative-only arrays)
        int max = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            // 2. Add current number to the "window"
            if (currentSum < 0) {
                // If previous streak was negative, discard it and start fresh at current num
                currentSum = 0;
            }
            currentSum += num;

            // 3. Update the global max
            max = Math.max(max, currentSum);
        }

        return max;
    }

    // =================================================================
    // Test Harness (Do not modify unless you want to add more tests)
    // =================================================================
    public static void main(String[] args) {
        MaxSubarraySolution solver = new MaxSubarraySolution();

        // Test Case 1
        int[] input1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected1 = 6;
        runTest(solver, 1, input1, expected1);

        // Test Case 2
        int[] input2 = {1};
        int expected2 = 1;
        runTest(solver, 2, input2, expected2);

        // Test Case 3
        int[] input3 = {5, 4, -1, 7, 8};
        int expected3 = 23;
        runTest(solver, 3, input3, expected3);
    }

    private static void runTest(MaxSubarraySolution solver, int testId, int[] input, int expected) {
        System.out.println("--------------------------------------------------");
        System.out.println("Test Case " + testId);
        System.out.println("Input: " + Arrays.toString(input));

        long startTime = System.nanoTime();
        int result = solver.maxSubArray(input);
        long endTime = System.nanoTime();

        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);

        if (result == expected) {
            System.out.println("Result:   ✅ PASS");
        } else {
            System.out.println("Result:   ❌ FAIL");
        }
        System.out.println("Time:     " + (endTime - startTime) / 1000 + " µs");
    }
}