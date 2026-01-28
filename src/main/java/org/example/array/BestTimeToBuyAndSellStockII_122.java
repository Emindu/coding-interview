package org.example.array;

import java.util.*;

/**
 * LeetCode 122. Best Time to Buy and Sell Stock II
 *
 * Goal:
 * - Implement two versions:
 *   1) maxProfitInitial: your first/straightforward approach
 *   2) maxProfitOptimized: your improved approach
 *
 * Rules:
 * - You can do as many transactions as you want.
 * - You can hold at most one share at a time.
 * - You may sell and buy on the same day (sell then buy).
 *
 * How to run locally:
 *   javac BestTimeToBuyAndSellStockII_122.java
 *   java BestTimeToBuyAndSellStockII_122
 */
public class BestTimeToBuyAndSellStockII_122 {

    // =========================
    // LeetCode-style method
    // =========================
    public int maxProfit(int[] prices) {
        // Choose which implementation to use
//        return maxProfitOptimized(prices);
         return maxProfitInitial(prices);
    }

    // =========================
    // Version 1: Initial solution (implement yourself)
    // =========================
    public static int maxProfitInitial(int[] prices) {
        // TODO: implement initial solution

        int sumProfit = 0;
        int currentBuyPoint = 0;

        for (int i = 0; i < prices.length; i++) {

            // update current buy Point



        }

        return -1;
    }

    // =========================
    // Version 2: Optimized solution (implement yourself)
    // =========================
    public static int maxProfitOptimized(int[] prices) {
        // TODO: implement optimized solution
        return -1;
    }

    // =========================
    // Test Harness
    // =========================
    public static void main(String[] args) {
        runAllTests();
        System.out.println("All tests finished.");
    }

    private static void runAllTests() {
        List<TestCase> tests = new ArrayList<>();

        // Examples
        tests.add(new TestCase(new int[]{7, 1, 5, 3, 6, 4}, 7, "Example 1"));
        tests.add(new TestCase(new int[]{1, 2, 3, 4, 5}, 4, "Example 2"));
        tests.add(new TestCase(new int[]{7, 6, 4, 3, 1}, 0, "Example 3"));

        // Edge cases
        tests.add(new TestCase(new int[]{5}, 0, "Single day"));
        tests.add(new TestCase(new int[]{2, 2, 2, 2}, 0, "Flat prices"));
        tests.add(new TestCase(new int[]{1, 2}, 1, "Two days increasing"));
        tests.add(new TestCase(new int[]{2, 1}, 0, "Two days decreasing"));
        tests.add(new TestCase(new int[]{3, 2, 6, 5, 0, 3}, 7, "Multiple waves"));

        // Run both implementations
        for (TestCase tc : tests) {
            assertEquals(tc.expected, safeCallInitial(tc.prices), "Initial - " + tc.name);
            assertEquals(tc.expected, safeCallOptimized(tc.prices), "Optimized - " + tc.name);
        }

        randomConsistencyCheck(200, 20, 10);
    }

    private static int safeCallInitial(int[] prices) {
        return maxProfitInitial(Arrays.copyOf(prices, prices.length));
    }

    private static int safeCallOptimized(int[] prices) {
        return maxProfitOptimized(Arrays.copyOf(prices, prices.length));
    }

    private static void randomConsistencyCheck(int iterations, int maxN, int maxPrice) {
        Random rnd = new Random(42);

        for (int it = 0; it < iterations; it++) {
            int n = 1 + rnd.nextInt(maxN);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rnd.nextInt(maxPrice + 1);
            }

            int a = safeCallInitial(arr);
            int b = safeCallOptimized(arr);

            if (a != b) {
                throw new AssertionError(
                        "Mismatch!\nprices=" + Arrays.toString(arr) +
                                "\ninitial=" + a + ", optimized=" + b
                );
            }
        }
    }

    // =========================
    // Helpers
    // =========================
    private static void assertEquals(int expected, int actual, String label) {
        if (expected != actual) {
            throw new AssertionError(
                    label + " FAILED\nExpected: " + expected + "\nActual:   " + actual
            );
        }
    }

    private static class TestCase {
        final int[] prices;
        final int expected;
        final String name;

        TestCase(int[] prices, int expected, String name) {
            this.prices = prices;
            this.expected = expected;
            this.name = name;
        }
    }
}
