package org.example.array;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

    // =========================
    // Entry Point (Local Tests)
    // =========================
    public static void main(String[] args) {

        // -------- Test Case 1 --------
        int[] nums1 = {1, 1, 2};
        int[] expected1 = {1, 2};

        runTest(nums1, expected1, "Test Case 1");

        // -------- Test Case 2 --------
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expected2 = {0, 1, 2, 3, 4};

        runTest(nums2, expected2, "Test Case 2");
    }

    // =========================
    // Test Runner
    // =========================
    private static void runTest(int[] nums, int[] expected, String testName) {
        int[] copyForInitial = Arrays.copyOf(nums, nums.length);
        int[] copyForOptimized = Arrays.copyOf(nums, nums.length);

        System.out.println("---- " + testName + " ----");

        int k1 = initialSolution(copyForInitial);
        validate(copyForInitial, k1, expected, "Initial Solution");

        int k2 = optimizedSolution(copyForOptimized);
        validate(copyForOptimized, k2, expected, "Optimized Solution");

        System.out.println();
    }

    private static void validate(int[] nums, int k, int[] expected, String label) {
        boolean passed = k == expected.length;

        for (int i = 0; i < k && passed; i++) {
            if (nums[i] != expected[i]) {
                passed = false;
            }
        }

        System.out.println(label + ": " + (passed ? "PASS ✅" : "FAIL ❌"));
        System.out.println("k = " + k);
        System.out.println("Result Array = " + Arrays.toString(nums));
    }

    // =================================================
    // TODO: Initial / Naive Implementation
    // =================================================
    public static int initialSolution(int[] nums) {
        // TODO: implement your first approach here

        HashSet<Integer> hashSet = new HashSet<>();

        int uniqueCount = 0;
        for (int i = 0; i < nums.length; i++) {

            if (!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
                nums[uniqueCount] = nums[i];
                uniqueCount ++;
            }
        }

        return hashSet.size();
    }

    // =================================================
    // TODO: Optimized Implementation
    // =================================================
    public static int optimizedSolution(int[] nums) {
        if(nums.length < 2){return nums.length;}
        int uniqueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[uniqueCount] != nums[i]){
                uniqueCount ++;
                nums[uniqueCount] = nums[i];

            }
        }


        return uniqueCount + 1;

    }
}
