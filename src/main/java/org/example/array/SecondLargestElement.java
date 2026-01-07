package org.example.array;

public class SecondLargestElement {

    // Method to find second largest element
    public static int findSecondLargest(int[] arr) {


        int maxValue = Integer.MIN_VALUE;
        int secondMaxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }

            if (maxValue > arr[i] && secondMaxIndex < arr[i]) {
                secondMaxIndex = arr[i];
            }


        }

        if (secondMaxIndex == Integer.MIN_VALUE) {
            return -1;
        }
        return secondMaxIndex;
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
        // Test case 1: Normal case
        int[] arr1 = {12, 35, 1, 10, 34, 1};

        // Test case 2: Array with duplicates
        int[] arr2 = {10, 5, 10};

        // Test case 3: Array with all same elements
        int[] arr3 = {5, 5, 5, 5};

        // Test case 4: Array with two elements
        int[] arr4 = {3, 7};

        // Test case 5: Larger array
        int[] arr5 = {100, 200, 50, 300, 150, 250};

        // Test case 6: Negative numbers
        int[] arr6 = {-1, -5, -3, -8, -2};

//        // Run tests
//        System.out.println("Test Case 1:");
//        printArray(arr1);
//        System.out.println("Second Largest: " + findSecondLargest(arr1));
//        System.out.println();

        System.out.println("Test Case 2:");
        printArray(arr2);
        System.out.println("Second Largest: " + findSecondLargest(arr2));
        System.out.println();

        System.out.println("Test Case 3:");
        printArray(arr3);
        System.out.println("Second Largest: " + findSecondLargest(arr3));
        System.out.println();

        System.out.println("Test Case 4:");
        printArray(arr4);
        System.out.println("Second Largest: " + findSecondLargest(arr4));
        System.out.println();

        System.out.println("Test Case 5:");
        printArray(arr5);
        System.out.println("Second Largest: " + findSecondLargest(arr5));
        System.out.println();

        System.out.println("Test Case 6:");
        printArray(arr6);
        System.out.println("Second Largest: " + findSecondLargest(arr6));
    }
}