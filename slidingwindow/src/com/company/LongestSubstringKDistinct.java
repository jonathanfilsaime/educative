package com.company;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        if (str == null || str.length() == 0) throw new IllegalArgumentException();

        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            characterFrequency.put(str.charAt(windowEnd), characterFrequency.getOrDefault(str.charAt(windowEnd), 0) + 1);

            while(characterFrequency.size() > k) {
                characterFrequency.put(str.charAt(windowStart), characterFrequency.get(str.charAt(windowStart)) - 1);
                if (characterFrequency.get(str.charAt(windowStart)) == 0) {
                    characterFrequency.remove(str.charAt(windowStart));
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println(LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println(LongestSubstringKDistinct.findLength("cbbebi", 3));
        System.out.println(LongestSubstringKDistinct.findLength("cbbebi", 10));
    }
}
