package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern){

        char[] patternChar = pattern.toCharArray();
        Arrays.sort(patternChar);

        int windowStart = 0, length = patternChar.length;
        for(int windowEnd = length; windowEnd <= str.length(); windowEnd++) {
            String subString = str.substring(windowStart, windowEnd);
            char[] subStringCharArray = subString.toCharArray();
            Arrays.sort(subStringCharArray);

            if(Arrays.equals(subStringCharArray, patternChar)) {
                List<Integer> integerList = new ArrayList<>();
                for(int value = windowStart; value < windowEnd; value++) {
                    integerList.add(value);
                }
                return integerList;
            } else {
                windowStart++;
            }
        }
        return new ArrayList<>();

    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
