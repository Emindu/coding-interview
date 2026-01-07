package org.example.hash;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumDev {

    public static void main(String[] args) {
        SolutionOptimize solution = new SolutionOptimize();

        System.out.println("--- Starting Tests ---\n");

        // Example 1
        runTestCase(solution, new int[]{2, 7, 11, 15}, 9, "[0, 1]");

        // Example 2
        runTestCase(solution, new int[]{3, 2, 4}, 6, "[1, 2]");

        // Example 3
        runTestCase(solution, new int[]{3, 3}, 6, "[0, 1]");
    }

    // Helper method to run tests and print results cleanly
    private static void runTestCase(SolutionOptimize solution, int[] nums, int target, String expectedDesc) {
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);

        long startTime = System.nanoTime();
        int[] result = solution.twoSum(nums, target);
        long endTime = System.nanoTime();

        System.out.println("Output:   " + Arrays.toString(result));
        System.out.println("Expected: " + expectedDesc);
        System.out.println("Time:     " + (endTime - startTime) + " ns");
        System.out.println("--------------------------------------------------");
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // TODO: Implement your logic here

        // Throwing exception or returning empty array to allow compilation until you start

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}


class SolutionOptimize {
public int[] twoSum(int[] nums, int target) {
    // TODO: Implement your logic here

    // Throwing exception or returning empty array to allow compilation until you start
    HashMap<Integer, Integer>  valueMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        valueMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
        int i1 = target - nums[i];
        if (valueMap.containsKey(i1) && (valueMap.get(i1) != i)){
             return new int[]{i,valueMap.get(i1)};
        }

    }
    return new int[]{};
}
}