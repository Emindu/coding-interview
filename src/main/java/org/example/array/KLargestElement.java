package org.example.array;

import java.util.Arrays;

public class KLargestElement {

    /**
     * Method to find the K-th largest element in the array.
     *
     * @param nums The input array
     * @param k   The rank of the largest number to find
     * @return The K-th largest value
     */
    public static int findKLargest(int[] nums, int k) {
        // FIX 1: Initialize with MIN_VALUE to handle negative numbers correctly
        int[] maxValues = new int[k];
        Arrays.fill(maxValues, Integer.MIN_VALUE);

        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];

            // Iterate through our leaderboard
            for (int j = 0; j < maxValues.length; j++) {

                // If current number is bigger than the one at this position...
                if (currentVal > maxValues[j]) {

                    // FIX 2: "The Domino Shift"
                    // Shift everyone below this position down by one slot
                    // We go backwards so we don't overwrite values we need to move
                    for (int m = maxValues.length - 1; m > j; m--) {
                        maxValues[m] = maxValues[m - 1];
                    }

                    // Insert the new value
                    maxValues[j] = currentVal;

                    // FIX 3: Break immediately so we don't insert the same number twice
                    // in lower positions during the same pass
                    break;
                }
            }
        }
        return maxValues[k - 1];
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // --- Test Case 1 ---
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int expected1 = 5;

        System.out.println("Test Case 1 (Find " + k1 + " largest):");
        printArray(arr1);
        int result1 = findKLargest(arr1, k1);
        System.out.println("Expected: " + expected1 + " | Actual: " + result1);
        System.out.println("Status: " + (result1 == expected1 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------------------------");

        // --- Test Case 2 ---
        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int expected2 = 4;

        System.out.println("Test Case 2 (Find " + k2 + " largest):");
        printArray(arr2);
        int result2 = findKLargest(arr2, k2);
        System.out.println("Expected: " + expected2 + " | Actual: " + result2);
        System.out.println("Status: " + (result2 == expected2 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------------------------");

        // --- Test Case 3 ---
        int[] arr3 = {5, 5, 5, 5};
        int k3 = 1;
        int expected3 = 5; // The largest is 5

        System.out.println("Test Case 3 (All duplicates):");
        printArray(arr3);
        int result3 = findKLargest(arr3, k3);
        System.out.println("Expected: " + expected3 + " | Actual: " + result3);
        System.out.println("Status: " + (result3 == expected3 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------------------------");

        // --- Test Case 4 ---
        int[] arr4 = {100, 200, 50, 300, 150, 250};
        int k4 = 3;
        int expected4 = 200;

        System.out.println("Test Case 4 (Large numbers):");
        printArray(arr4);
        int result4 = findKLargest(arr4, k4);
        System.out.println("Expected: " + expected4 + " | Actual: " + result4);
        System.out.println("Status: " + (result4 == expected4 ? "PASS" : "FAIL"));
        System.out.println("--------------------------------------------------");

        // --- Test Case 5 ---
        int[] arr5 = {-1, -5, -3, -8, -2};
        int k5 = 2;
        int expected5 = -2;

        System.out.println("Test Case 5 (Negative numbers):");
        printArray(arr5);
        int result5 = findKLargest(arr5, k5);
        System.out.println("Expected: " + expected5 + " | Actual: " + result5);
        System.out.println("Status: " + (result5 == expected5 ? "PASS" : "FAIL"));
    }
}