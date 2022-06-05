import java.util.*;

class RearrangeString {

    public static String rearrangeString(String str) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(char c : str.toCharArray()) frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        StringBuilder stringBuilder = new StringBuilder(str.length());
        Map.Entry<Character, Integer> previous = null;

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            if(previous != null && previous.getValue() > 0) maxHeap.add(previous);

            stringBuilder.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previous = currentEntry;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}