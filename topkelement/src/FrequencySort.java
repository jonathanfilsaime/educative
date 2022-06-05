import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {

        char[] strArrays = str.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();

       for(char c : strArrays) {
           frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
       }

       PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
       maxHeap.addAll(frequencyMap.entrySet());

       StringBuilder stb = new StringBuilder();

       while(!maxHeap.isEmpty()) {

           char c = maxHeap.peek().getKey();
           int count = maxHeap.peek().getValue();

           for (int i = 0; i < count; i++) {
               stb.append(c);
           }

           maxHeap.poll();
       }

        return stb.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}