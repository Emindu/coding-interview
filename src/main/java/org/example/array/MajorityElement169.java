package org.example.array;
import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement169 {

    // ===============================
    // Solution 1: Initial Approach
    // (e.g., brute force / hashmap)
    // ===============================
    public static int majorityElementInitial(int[] nums) {
        // TODO: implement initial solution

        if (nums.length == 1){
            return nums[0];
        }
        int thresold = nums.length / 2;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])){
                Integer i1 = countMap.get(nums[i]) + 1;
                countMap.put(nums[i], i1);

                if (i1 > thresold){
                    return nums[i];
                }

            } else {
                countMap.put(nums[i], 1);
            }
        }
        
        
        return -1;
    }

    // ===============================
    // Solution 2: Optimized Approach
    // (O(n) time, O(1) space)
    // ===============================
    public static int majorityElementOptimized(int[] nums) {

                int candidate = 0;
                int count = 0;

                for (int x : nums) {
                    if (count == 0) {
                        candidate = x;
                    }
                    count += (x == candidate) ? 1 : -1;
                }

                return candidate;
            }




    // ===============================
    // Test Harness
    // ===============================
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        test(new int[]{3, 2, 3}, 3);
        test(new int[]{2, 2, 1, 1, 1, 2, 2}, 2);
        test(new int[]{1}, 1);
        test(new int[]{5, 5, 5, 2, 3, 5, 5}, 5);
    }

    private static void test(int[] nums, int expected) {
        int result1 = majorityElementInitial(Arrays.copyOf(nums, nums.length));
        int result2 = majorityElementOptimized(Arrays.copyOf(nums, nums.length));

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Expected: " + expected);
        System.out.println("Initial Solution Result: " + result1);
        System.out.println("Optimized Solution Result: " + result2);
        System.out.println("--------------------------------------------------");
    }
}
