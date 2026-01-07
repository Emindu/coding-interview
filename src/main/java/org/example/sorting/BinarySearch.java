package org.example.sorting;

public class BinarySearch {

    public static void main(String[] args) {

//        // Example 1
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("Input: nums = [-1,0,3,5,9,12], target = 9");
        int result1 = search(nums1, target1);
        System.out.println("Output: " + result1); // Expected: 4

        System.out.println("---");

        // Example 2
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        System.out.println("Input: nums = [-1,0,3,5,9,12], target = 2");
        int result2 = search(nums2, target2);
        System.out.println("Output: " + result2); // Expected: -1
    }


    public static int search(int[] nums, int target) {

        // TODO: Implement O(log n) binary search logic here

        int leftIndex = 0;
        int rightIndex = nums.length;
        int lastMiddle = 0;

        while(leftIndex < rightIndex){
            //getting middle index
            int middleApproximate = leftIndex +  ((rightIndex - leftIndex) / 2);

            if (target == nums[middleApproximate]){
                return middleApproximate;
            }

            if(lastMiddle == middleApproximate){
                return -1;
            }

            lastMiddle = middleApproximate;


            if (target > nums[middleApproximate]){
                leftIndex = middleApproximate;
            } else {
                rightIndex = middleApproximate;
            }
        }
        return -1; // Default return if not found
    }
}

