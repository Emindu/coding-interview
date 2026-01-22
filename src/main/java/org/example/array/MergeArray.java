package org.example.array;

import java.util.Arrays;

public class MergeArray {

    // LeetCode method signature (DO NOT CHANGE)
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int point2 = 0; // index trace of 2nd array

        for (int i = 0; i < nums1.length; i++) {
            if (point2 < n && nums2[point2] < nums1[i]  ){
                swap(nums1, i, nums2[point2]);
                point2++;
                m++;
            } else if (i >= m && point2 < n){
                nums1[i] = nums2[point2];
                point2++;
            }


        }
    }
    
    private void swap(int[] nums1, int index, int newValue){

        int valueToAdd = newValue;
        for (int i = index; i < nums1.length; i++) {

            int temp = nums1[i];
            nums1[i] = valueToAdd;
            valueToAdd = temp;
        }
    }

    // -----------------------------
    // Local testing entry point
    // -----------------------------
    public static void main(String[] args) {
        MergeArray solution = new MergeArray();

        // ---------- Test Case 1 ----------
        int[] nums1_case1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2_case1 = {2, 5, 6};
        int n1 = 3;

        solution.merge(nums1_case1, m1, nums2_case1, n1);
        printResult("Test Case 1", nums1_case1);

        // ---------- Test Case 2 ----------
        int[] nums1_case2 = {1};
        int m2 = 1;
        int[] nums2_case2 = {};
        int n2 = 0;

        solution.merge(nums1_case2, m2, nums2_case2, n2);
        printResult("Test Case 2", nums1_case2);

        // ---------- Test Case 3 ----------
        int[] nums1_case3 = {0};
        int m3 = 0;
        int[] nums2_case3 = {1};
        int n3 = 1;

        solution.merge(nums1_case3, m3, nums2_case3, n3);
        printResult("Test Case 3", nums1_case3);
    }

    // -----------------------------
    // Utility method for printing
    // -----------------------------
    private static void printResult(String label, int[] nums) {
        System.out.println(label + " → " + Arrays.toString(nums));
    }
}
