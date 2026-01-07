package org.example.sorting;

import java.util.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestMatrix {

    public static void main(String[] args) {
        KthSmallestMatrix solution = new KthSmallestMatrix();

        // Example 1
        int[][] matrix1 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k1 = 8;
        System.out.println("Input: matrix = " + Arrays.deepToString(matrix1) + ", k = " + k1);
        int result1 = solution.kthSmallest(matrix1, k1);
        System.out.println("Output: " + result1); // Expected: 13

        System.out.println("---");

        // Example 2
        int[][] matrix2 = {
                {-5}
        };
        int k2 = 1;
        System.out.println("Input: matrix = " + Arrays.deepToString(matrix2) + ", k = " + k2);
        int result2 = solution.kthSmallest(matrix2, k2);
        System.out.println("Output: " + result2); // Expected: -5

        // Example 3 (From your Screenshot - Failing Test Case)
        int[][] matrix3 = {
                {1, 2},
                {1, 3}
        };
        int k3 = 2;
        System.out.println("Input: matrix = " + Arrays.deepToString(matrix3) + ", k = " + k3);
        int result3 = solution.kthSmallest(matrix3, k3);
        System.out.println("Output: " + result3); // Expected: 1
    }

    // LeetCode method added directly here
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> keepMaxValues =
                new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if (keepMaxValues.size() < k){
                    keepMaxValues.add(matrix[i][j]);
                } else {
                    if (keepMaxValues.peek() > matrix[i][j]){
                        keepMaxValues.poll();
                        keepMaxValues.add(matrix[i][j]);
                    }
                }

            }

        }
        // TODO: Implement logic here

        return keepMaxValues.peek(); // Placeholder
    }
}