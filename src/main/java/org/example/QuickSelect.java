package org.example;

import java.util.Arrays;

public class QuickSelect {

    /**
     * Finds the k-th smallest element in an array.
     * @param arr The input array
     * @param k The rank (e.g., 1 for 1st smallest, 3 for 3rd smallest)
     * @return The value of the k-th smallest element
     */
    public static int findKthSmallest(int[] arr, int k) {
        // Validate input
        if (arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid input or k is out of bounds");
        }

        // We pass 'k - 1' because arrays are 0-indexed.
        // If we want the 3rd smallest, we are looking for the element at index 2.
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int low, int high, int kIndex) {
        // Partition the array
        int partitionIndex = partition(arr, low, high);

        // Case 1: The pivot is exactly at the k-th position
        if (partitionIndex == kIndex) {
            return arr[partitionIndex];
        }

        // Case 2: The pivot is to the right of our target; search the left side
        else if (partitionIndex > kIndex) {
            return quickSelect(arr, low, partitionIndex - 1, kIndex);
        }

        // Case 3: The pivot is to the left of our target; search the right side
        else {
            return quickSelect(arr, partitionIndex + 1, high, kIndex);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pick last element as pivot
        int i = low;

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        // Place the pivot in its correct sorted position
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 8, 6, 11, 26};
        int k = 3;

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Note: This modifies the array order due to partitioning!
        int result = findKthSmallest(arr, k);

        System.out.println("The " + k + "rd smallest element is: " + result);
        System.out.println("Array after processing: " + Arrays.toString(arr));
    }
}