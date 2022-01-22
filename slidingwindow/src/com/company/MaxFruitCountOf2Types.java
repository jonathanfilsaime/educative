package com.company;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> fruitFrequency = new HashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequency.put(arr[windowEnd], fruitFrequency.getOrDefault(arr[windowEnd], 0) + 1);

            while(fruitFrequency.size() > 2) {
                fruitFrequency.put(arr[windowStart], fruitFrequency.get(arr[windowStart]) - 1);
                if (fruitFrequency.get(arr[windowStart]) == 0) fruitFrequency.remove(arr[windowStart]);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println(MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
