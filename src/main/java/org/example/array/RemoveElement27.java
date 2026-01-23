package org.example.array;

import java.util.Arrays;

public class RemoveElement27 {

    // ====== DO NOT CHANGE METHOD SIGNATURE ======
    public static int removeElement(int[] nums, int val) {



        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    // ====== TEST HARNESS ======
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        test(
                new int[]{3, 2, 2, 3},
                3,
                new int[]{2, 2}
        );

        test(
                new int[]{0, 1, 2, 2, 3, 0, 4, 2},
                2,
                new int[]{0, 0, 1, 3, 4}
        );

        test(
                new int[]{},
                1,
                new int[]{}
        );

        test(
                new int[]{1, 1, 1},
                1,
                new int[]{}
        );

        test(
                new int[]{4, 5},
                3,
                new int[]{4, 5}
        );

        System.out.println("All tests executed.");
    }

    private static void test(int[] nums, int val, int[] expected) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        int k = removeElement(copy, val);

        if (k != expected.length) {
            fail(nums, val, expected, copy, k, "Incorrect length returned");
        }

        Arrays.sort(copy, 0, k);
        Arrays.sort(expected);

        for (int i = 0; i < k; i++) {
            if (copy[i] != expected[i]) {
                fail(nums, val, expected, copy, k, "Incorrect elements after removal");
            }
        }

        System.out.println("✅ Passed: nums=" + Arrays.toString(nums) + ", val=" + val);
    }

    private static void fail(
            int[] original,
            int val,
            int[] expected,
            int[] actual,
            int k,
            String message
    ) {
        System.out.println("❌ FAILED");
        System.out.println("Reason: " + message);
        System.out.println("Original nums: " + Arrays.toString(original));
        System.out.println("val: " + val);
        System.out.println("Returned k: " + k);
        System.out.println("First k elements: " + Arrays.toString(Arrays.copyOf(actual, k)));
        System.out.println("Expected elements: " + Arrays.toString(expected));
        System.exit(1);
    }
}
