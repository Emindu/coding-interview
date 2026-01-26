package org.example.array;

import java.util.*;
import java.util.function.BiConsumer;

public class RotateArray189 {

    // ============================================================
    // 1) Problem method signature (LeetCode-style)
    // ============================================================
    static class Solution {
        public void rotate(int[] nums, int k) {

            int[] numsTemp = nums.clone();

            for (int i = 0; i < nums.length; i++) {
                int i1 = i - (k % nums.length);
                if (i1 < 0){
                    i1 = nums.length + i1 ;
                }

                nums[i] = numsTemp[i1];
            }
            // TODO: implement your initial solution here (e.g., extra array)
            // Hint: k can be > nums.length, so usually do k %= n.
        }
    }

    // ============================================================
    // 2) A second (optimized) solution to compare (O(1) extra space)
    //    Keep signature compatible; name differs to compile in one file.
    // ============================================================

    static class OptimizedSolution {

        static void reverse(int [] nums, int start, int end){
            while(start<end){
                int temp = nums[start];
                nums[start]=nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        public void rotate(int[] nums, int k) {

            k = k%nums.length;

            //reverse first nums.length - k element
            reverse(nums, 0, nums.length - k -1);

            //reverse last k element
            reverse(nums, nums.length-k, nums.length-1);

            //reverse whole array
            reverse(nums, 0, nums.length-1);
        }
    }

    // ============================================================
    // 3) Test harness (run locally)
    // ============================================================
    public static void main(String[] args) {
        runAllTests("Solution", (arr, k) -> new Solution().rotate(arr, k));
        runAllTests("OptimizedSolution", (arr, k) -> new OptimizedSolution().rotate(arr, k));

        // Optional: Compare both implementations against each other on random tests
        compareImplementationsRandomly(
                (arr, k) -> new Solution().rotate(arr, k),
                (arr, k) -> new OptimizedSolution().rotate(arr, k),
                200,   // trials
                50,    // max n
                200    // max k
        );

        System.out.println("\nAll done.");
    }

    // ============================================================
    // 4) Core test runner utilities
    // ============================================================
    private static void runAllTests(String name, BiConsumer<int[], Integer> rotateFn) {
        System.out.println("Running tests for: " + name);

        // Provided examples
        assertRotate(rotateFn, new int[]{1,2,3,4,5,6,7}, 3, new int[]{5,6,7,1,2,3,4});
        assertRotate(rotateFn, new int[]{-1,-100,3,99}, 2, new int[]{3,99,-1,-100});

        // Edge cases
        assertRotate(rotateFn, new int[]{1}, 0, new int[]{1});
        assertRotate(rotateFn, new int[]{1}, 100000, new int[]{1}); // large k
        assertRotate(rotateFn, new int[]{1,2}, 0, new int[]{1,2});
        assertRotate(rotateFn, new int[]{1,2}, 1, new int[]{2,1});
        assertRotate(rotateFn, new int[]{1,2}, 2, new int[]{1,2});
        assertRotate(rotateFn, new int[]{1,2}, 3, new int[]{2,1});  // k > n
        assertRotate(rotateFn, new int[]{1,2,3}, 4, new int[]{3,1,2}); // k > n

        // Negative numbers + duplicates
        assertRotate(rotateFn, new int[]{0,0,0}, 1, new int[]{0,0,0});
        assertRotate(rotateFn, new int[]{2,2,3,3,4}, 2, new int[]{3,4,2,2,3});

        // Larger simple pattern
        assertRotate(rotateFn, new int[]{1,2,3,4,5}, 10, new int[]{1,2,3,4,5}); // k multiple of n

        System.out.println("✅ Passed: " + name + "\n");
    }

    private static void assertRotate(BiConsumer<int[], Integer> rotateFn, int[] nums, int k, int[] expected) {
        int[] input = Arrays.copyOf(nums, nums.length);
        rotateFn.accept(input, k);

        if (!Arrays.equals(input, expected)) {
            throw new AssertionError(
                    "Test failed!\n"
                            + "nums=" + Arrays.toString(nums) + ", k=" + k + "\n"
                            + "expected=" + Arrays.toString(expected) + "\n"
                            + "actual  =" + Arrays.toString(input)
            );
        }
    }

    // ============================================================
    // 5) Randomized cross-check: Solution vs OptimizedSolution
    //    (Useful once you implement both.)
    // ============================================================
    private static void compareImplementationsRandomly(
            BiConsumer<int[], Integer> fnA,
            BiConsumer<int[], Integer> fnB,
            int trials,
            int maxN,
            int maxK
    ) {
        System.out.println("Random cross-check (A vs B): " + trials + " trials");

        Random rnd = new Random(1); // deterministic seed
        for (int t = 0; t < trials; t++) {
            int n = 1 + rnd.nextInt(maxN);
            int k = rnd.nextInt(maxK + 1);

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                // keep values small to help debugging
                arr[i] = rnd.nextInt(21) - 10; // [-10..10]
            }

            int[] a = Arrays.copyOf(arr, n);
            int[] b = Arrays.copyOf(arr, n);

            fnA.accept(a, k);
            fnB.accept(b, k);

            if (!Arrays.equals(a, b)) {
                throw new AssertionError(
                        "Mismatch found!\n"
                                + "orig=" + Arrays.toString(arr) + ", k=" + k + "\n"
                                + "A   =" + Arrays.toString(a) + "\n"
                                + "B   =" + Arrays.toString(b)
                );
            }
        }

        System.out.println("✅ Random cross-check passed\n");
    }

    // ============================================================
    // 6) Optional helper you may use in optimized approach
    //    (Not used yet; safe boilerplate.)
    // ============================================================
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
