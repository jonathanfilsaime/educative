import java.util.*;

class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for( int i = 0; i < nums.length; i++) {
           insert(nums[i]);
           balance();

           if (i - k + 1 >= 0) {
               result[i - k + 1] =findMedian();

               int elementRemoved = nums[i - k + 1];
               if (elementRemoved <= maxHeap.peek()) maxHeap.remove(elementRemoved);
               else minHeap.remove(elementRemoved);

               balance();
           }
        }
        return result;
    }

    public void insert(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= num) maxHeap.add(num);
        else minHeap.add(num);
    }

    private void balance() {
        if (maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}