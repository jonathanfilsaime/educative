import java.util.*;

class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        // TODO: Write your code here
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(Character ch: tasks) frequencyMap.put(ch.toString(), frequencyMap.getOrDefault(ch.toString(), 0) + 1);

        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        Stack<Map.Entry<String, Integer>> stack = new Stack<>();
        List<String> resultList = new ArrayList<>();

        while(!maxHeap.isEmpty()) {
            for (int j = 0; j <= k && !maxHeap.isEmpty(); j++) {
                Map.Entry<String, Integer> currentEntry = maxHeap.poll();
                resultList.add(currentEntry.getKey());
                currentEntry.setValue(currentEntry.getValue() - 1);

                if (currentEntry.getValue() > 0) {
                    stack.add(currentEntry);
                }
            }

//            for(int i = 0; i < k; i++) {
//                resultList.add("idle");
//            }

            maxHeap.addAll(stack);
            stack.clear();
        }

        for(String str : resultList) {
            System.out.print(str + " -> ");
        }

        return resultList.size();
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}