package org.example.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsDev {

    public static void main(String[] args) {
        System.out.println("--- Starting Tests ---\n");

        // Example 1
        runTestCase(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                "[[bat], [nat, tan], [ate, eat, tea]]"
        );

        // Example 2
        runTestCase(
                new String[]{""},
                "[[  ]]"
        );

        // Example 3
        runTestCase(
                new String[]{"a"},
                "[[a]]"
        );
    }

    // Wrapper to run tests
    private static void runTestCase(String[] strs, String expectedDesc) {
        System.out.println("Input: strs = " + Arrays.toString(strs));

        long startTime = System.nanoTime();
        // Calling the method directly below
        List<List<String>> result = groupAnagrams(strs);
        long endTime = System.nanoTime();

        System.out.println("Output:   " + result);
        System.out.println("Expected: " + expectedDesc);
        System.out.println("Time:     " + (endTime - startTime) + " ns");
        System.out.println("--------------------------------------------------");
    }

    // ---------------------------------------------------------
    // YOUR SOLUTION METHOD BELOW
    // ---------------------------------------------------------

    public static List<List<String>> groupAnagrams(String[] strs) {
        // TODO: Implement your logic here

        HashMap<String, List<String>> groupMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String str = strs[i];
            char[] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            String key = Arrays.toString(strCharArray);


            if (groupMap.containsKey(key)) {
                groupMap.get(key).add(str);
            } else {
                groupMap.put(key, new ArrayList<>());
                groupMap.get(key).add(str);
            }
        }

        return  groupMap.values().stream().toList();
    }
}