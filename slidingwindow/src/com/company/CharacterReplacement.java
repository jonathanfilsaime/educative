package com.company;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            characterFrequency.put(str.charAt(windowEnd), characterFrequency.getOrDefault(str.charAt(windowEnd), 0) + 1);
            maxLength = Math.max(characterFrequency.get(str.charAt(windowEnd)), maxLength);
        }
        return maxLength + k;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
