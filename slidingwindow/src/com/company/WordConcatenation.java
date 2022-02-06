package com.company;

import java.util.*;

public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) throws Exception {
        List<Integer> resultIndices = new ArrayList<>();
        int wordSize = words[0].length();
        int subStringSize = words.length * wordSize;
        int windowStart = 0;
        Map<String, Integer> wordFrequencyTracker = new HashMap<>();
        Arrays.stream(words).iterator().forEachRemaining(x -> wordFrequencyTracker.put(x, wordFrequencyTracker.getOrDefault(x, 0) + 1));
        Map<String, Integer> strWordFrequencyTracker = new HashMap<>();

        for(int windowEnd = subStringSize; windowEnd < str.length() + 1; windowEnd++) {

            int count = wordSize + windowStart;
            int beginning = windowStart;

            while(strWordFrequencyTracker.size() < wordFrequencyTracker.size() && (count - windowStart) <= subStringSize) {
                strWordFrequencyTracker.put(str.substring(beginning, count), strWordFrequencyTracker.getOrDefault(str.substring(beginning, count), 0) + 1);
                beginning = count;
                count += wordSize;
            }

            if(wordFrequencyTracker.keySet().equals(strWordFrequencyTracker.keySet()) && new ArrayList<>(wordFrequencyTracker.values()).equals(new ArrayList<>(strWordFrequencyTracker.values()))) {
                resultIndices.add(windowStart);
            }
            strWordFrequencyTracker.clear();
            windowStart++;
        }
        return resultIndices;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(WordConcatenation.findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(WordConcatenation.findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
    }
}
