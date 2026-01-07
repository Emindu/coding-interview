package org.example.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        int result1 = solution.findKthLargest(nums1, k1);
        System.out.println("Output: " + result1); // Expected: 5

        System.out.println("---");

        // Example 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println("Output: " + result2); // Expected: 4
    }
}

// Paste your LeetCode solution class here
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // below is for tracing k largest values
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);


        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k){
                priorityQueue.add(nums[i]);
                continue;
            }


            if (priorityQueue.peek() < nums[i]){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }

        return priorityQueue.peek(); // Placeholder
    }
}