import java.util.*;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        if(k <= 1) return str;

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(Character c : str.toCharArray()) frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        StringBuilder resultString = new StringBuilder(str.length());

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            resultString.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            queue.offer(entry);

            if(queue.size() == k) {
                Map.Entry<Character, Integer> currentEntry = queue.poll();
                if(currentEntry.getValue() > 0) {
                    maxHeap.add(currentEntry);
                }
            }
        }

        return resultString.length() == str.length() ? resultString.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}