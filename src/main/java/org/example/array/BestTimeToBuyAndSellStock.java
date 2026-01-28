package org.example.array;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    // =========================
    // Initial Solution (Brute / First Thought)
    // =========================
    // TODO: Implement your initial approach here
    public static int maxProfitInitial(int[] prices) {
        // TODO
        int currentLowIndex = 0;
        int maxProfit = 0;


        for (int i = 0; i < prices.length; i++) {
            int currentProfit = prices[i] - prices[currentLowIndex];

            if (currentProfit > maxProfit){
                maxProfit = currentProfit;
            }

            if (prices[currentLowIndex] > prices[i] ){
                currentLowIndex = i ;
            }
        }

        return maxProfit;
    }

    // =========================
    // Optimized Solution
    // =========================
    // TODO: Implement your optimized approach here
    public static int maxProfitOptimized(int[] prices) {
        // TODO
        return 0;
    }

    // =========================
    // Test Runner
    // =========================
    public static void main(String[] args) {
        runTest(new int[]{7, 1, 5, 3, 6, 4}, 5);
        runTest(new int[]{7, 6, 4, 3, 1}, 0);
        runTest(new int[]{1}, 0);
        runTest(new int[]{2, 4, 1}, 2);
        runTest(new int[]{3, 3, 3, 3, 3}, 0);
        runTest(new int[]{1, 2}, 1);
        runTest(new int[]{5, 4, 3, 2, 1, 10}, 9);
    }

    private static void runTest(int[] prices, int expected) {
        int resultInitial = maxProfitInitial(Arrays.copyOf(prices, prices.length));
        int resultOptimized = maxProfitOptimized(Arrays.copyOf(prices, prices.length));

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Expected: " + expected);
        System.out.println("Initial Result:   " + resultInitial);
        System.out.println("Optimized Result: " + resultOptimized);
        System.out.println(
                (resultInitial == expected && resultOptimized == expected)
                        ? "✅ PASS"
                        : "❌ FAIL"
        );
        System.out.println("-----------------------------------");
    }
}
