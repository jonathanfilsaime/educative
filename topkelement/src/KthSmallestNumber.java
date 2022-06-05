import java.util.*;

class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        // TODO: Write your code here

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        for(int num: nums) {
            minHeap.add(num);
        }

        for(int i = 0; i < k; i++) {

            if(i == k - 1 && !minHeap.isEmpty()) {
                return minHeap.poll();
            }
            minHeap.poll();
        }

        return -1;
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}