package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        // TODO: Write your code here
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> strCompareMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        int windowStart = -1;
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
        String value ="";

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            if (patternMap.containsKey(str.charAt(windowEnd))) {
                strCompareMap.put(str.charAt(windowEnd), strCompareMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
            }

            if(strCompareMap.getOrDefault(str.charAt(windowEnd), 0) > patternMap.getOrDefault(str.charAt(windowEnd), 0)) {
                strCompareMap.clear();
                strCompareMap.put(str.charAt(windowEnd), strCompareMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
                windowStart = windowEnd;
            }

            while(strCompareMap.keySet().equals(patternMap.keySet()) && (new ArrayList<>( strCompareMap.values() ).equals(new ArrayList<>( patternMap.values() )))) {
                start = windowStart;
                end = windowEnd;
                value = str.substring(start, end + 1);
                windowStart++;
                if(strCompareMap.containsKey(str.charAt(windowStart))) {
                    strCompareMap.put(str.charAt(windowStart), strCompareMap.get(str.charAt(windowStart)) -1);
                }
            }
        }


        return value;
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
    }
}
