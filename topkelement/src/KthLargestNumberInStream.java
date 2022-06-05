import java.util.*;

class KthLargestNumberInStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    int count;

    public KthLargestNumberInStream(int[] nums, int k) {
        count = k;
        for(int num : nums) {
           maxHeap.add(num);
       }
    }

    public int add(int num) {
        PriorityQueue<Integer> maxCurrentHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(num);
        maxCurrentHeap.addAll(maxHeap);

        for(int i = 1; i < count; i++) {
            maxCurrentHeap.poll();
        }

        if(!maxCurrentHeap.isEmpty()) return maxCurrentHeap.poll();
        else return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}