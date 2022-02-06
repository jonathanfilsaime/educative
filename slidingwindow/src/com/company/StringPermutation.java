package com.company;

import java.util.Arrays;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) throws Exception {
        if ( str.length() < pattern.length()) {
            throw new Exception("pattern is longer than the string");
        }

        char[] patternChar = pattern.toCharArray();
        Arrays.sort(patternChar);

        int windowStart = 0, length = patternChar.length;
        for(int windowEnd = length; windowEnd <= str.length(); windowEnd++) {
            String subString = str.substring(windowStart, windowEnd);
            char[] subStringCharArray = subString.toCharArray();
            Arrays.sort(subStringCharArray);

            if(Arrays.equals(subStringCharArray, patternChar)) {
                return true;
            } else {
                windowStart++;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println(StringPermutation.findPermutation("odicf", "dc"));
        System.out.println(StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println(StringPermutation.findPermutation("aaacb", "abc"));
    }
}
