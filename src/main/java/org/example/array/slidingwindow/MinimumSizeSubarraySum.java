package org.example.array.slidingwindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        // Example 1
        int target1 = 11;
        int[] nums1 = {1,2,3,4,5};

        printResult(1, target1, nums1, 3);

//        // Example 2
//        int target2 = 4;
//        int[] nums2 = {1, 4, 4};
//        printResult(2, target2, nums2, 1);
//
//        // Example 3
//        int target3 = 11;
//        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
//        printResult(3, target3, nums3, 0);
    }

    /**
     * YOUR CODE GOES HERE
     */
    public static int minSubArrayLen(int target, int[] nums) {
        // Write your logic here

        int rightIndex = 1;
        int leftIndex = 0;
        int minCount = nums.length + 1;
        while (leftIndex < nums.length - 1 ) {
            int sum = 0;

            for (int i1 = leftIndex; i1 <= rightIndex; i1++) {
                sum = sum + nums[i1];
            }
            if(sum == target){
                minCount = Math.min(minCount, rightIndex+1-leftIndex);
                leftIndex++;
            } else if (sum < target && rightIndex < nums.length -1){
                rightIndex++;
            } else {
                leftIndex++;
            }
            
        }

        if (minCount==nums.length + 1){
            minCount = 0;
        }

        return minCount; // Placeholder
    }

    // Helper method to print results clearly
    private static void printResult(int testNum, int target, int[] nums, int expected) {
        int result = minSubArrayLen(target, nums);
        System.out.println("--- Test Case " + testNum + " ---");
        System.out.println("Target: " + target);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println(result == expected ? "RESULT: PASS" : "RESULT: FAIL");
        System.out.println();
    }
}
