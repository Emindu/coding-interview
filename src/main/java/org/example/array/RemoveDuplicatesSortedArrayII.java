package org.example.array;

import java.util.Arrays;

public class RemoveDuplicatesSortedArrayII {

    // =============================
    // Initial / Brute-force attempt
    // =============================
    // Idea placeholder:
    // - Simple thinking
    // - Maybe count occurrences manually
    // - Not optimized for elegance
    public static int removeDuplicatesInitial(int[] nums) {
        // TODO: implement initial approach here


        int similarCount = 0;
        int uniquePlacement = 0;

        if (nums.length < 2  ){
            return nums.length;
        }

        int lastValue = 0;


        for (int i = 0; i < nums.length; i++) {

            if (i == 0){
                lastValue = nums[i];
                similarCount++;
                continue;
            }


            if (nums[i] == lastValue && similarCount < 2){
                uniquePlacement++;
                nums[uniquePlacement] = lastValue;
                similarCount++;
            }

            if (nums[i] !=  lastValue){
                similarCount = 1;
                lastValue = nums[i];
                uniquePlacement++;
                nums[uniquePlacement] = nums[i];

            }
        }

        return uniquePlacement + 1; // placeholder
    }

    // =============================
    // Optimized / Interview-ready
    // =============================
    // Idea placeholder:
    // - Two pointers
    // - In-place overwrite
    // - Allow at most two duplicates
    public static int removeDuplicatesOptimized(int[] nums) {
        // TODO: implement optimized approach here

        return 0; // placeholder
    }

    // =============================
    // Test Harness (Local Run)
    // =============================
    public static void main(String[] args) {

        int[] nums6 = {1};
        runTest(nums6, 1, new int[]{1});

        int[] nums5 = {1, 2};
        runTest(nums5, 2, new int[]{1, 2});

        // -------- Test Case 1 --------
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        runTest(nums1, 5, new int[]{1, 1, 2, 2, 3});

        // -------- Test Case 2 --------
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        runTest(nums2, 7, new int[]{0, 0, 1, 1, 2, 3, 3});

        // -------- Edge Case --------
        int[] nums3 = {};
        runTest(nums3, 0, new int[]{});

        // -------- Small Input --------
        int[] nums4 = {1, 1};
        runTest(nums4, 2, new int[]{1, 1});

        System.out.println("All tests executed.");
    }

    // =============================
    // Helper Method for Testing
    // =============================
    private static void runTest(int[] nums, int expectedK, int[] expectedPrefix) {
        int[] copyForInitial = Arrays.copyOf(nums, nums.length);
        int[] copyForOptimized = Arrays.copyOf(nums, nums.length);

        int k1 = removeDuplicatesInitial(copyForInitial);
        int k2 = removeDuplicatesOptimized(copyForOptimized);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Initial k = " + k1 + ", Result = " +
                Arrays.toString(Arrays.copyOf(copyForInitial, k1)));
        System.out.println("Optimized k = " + k2 + ", Result = " +
                Arrays.toString(Arrays.copyOf(copyForOptimized, k2)));
        System.out.println("Expected k = " + expectedK +
                ", Expected = " + Arrays.toString(expectedPrefix));
        System.out.println("--------------------------------------------------");
    }
}
