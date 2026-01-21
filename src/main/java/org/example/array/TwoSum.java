package org.example.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        runTest(solution, new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}, "Test Case 1");

        // Test Case 2
        runTest(solution, new int[]{3, 2, 4}, 6, new int[]{1, 2}, "Test Case 2");

        // Test Case 3
        runTest(solution, new int[]{3, 3}, 6, new int[]{0, 1}, "Test Case 3");
    }

    private static void runTest(Solution sol, int[] nums, int target, int[] expected, String testName) {
        int[] result = sol.twoSum(nums, target);

        // Sort both because the problem says "you can return the answer in any order"
        if (result != null) Arrays.sort(result);
        if (expected != null) Arrays.sort(expected);

        if (Arrays.equals(result, expected)) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
            System.out.println("   Expected: " + Arrays.toString(expected));
            System.out.println("   Actual:   " + Arrays.toString(result));
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int wantedValue = target - nums[i];
            if (integerIntegerHashMap.containsKey(wantedValue)){
                return new int[] {integerIntegerHashMap.get(wantedValue), i};

            }

            integerIntegerHashMap.put(nums[i], i);
        }

        return new int[] {};

    }
}