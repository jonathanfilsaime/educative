import java.util.*;

class Item {
    int from;
    int value;

    Item(int from, int value) {
        this.from = from;
        this.value = value;
    }
}
class LargestPairs {

    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        // TODO: Write your code here

        Queue<Item> maxHeap1 = new PriorityQueue<>((a, b) -> b.value - a.value);
        Queue<Item> maxHeap2 = new PriorityQueue<>((a, b) -> b.value - a.value);

        for(int i = 0; i < nums1.length - 1 && i < nums2.length; i++) {
            maxHeap1.add(new Item(1, nums1[i]));
            maxHeap2.add(new Item(2, nums2[i]));
        }

        int previous1 = 0;
        int previous2 = 0;
        int count = 0;

        while(count < k) {
            int currentNum1 = 0;
            if(!maxHeap1.isEmpty())  {
                currentNum1 = maxHeap1.poll().value;
            }
            int currentNum2 = 0;
            if(!maxHeap2.isEmpty()) {
                currentNum2 = maxHeap2.poll().value;
            }
            int result1 = 0;
            int result2 = 0;

            if(currentNum1 > previous1) {
                result1 = currentNum1;
            } else {
                result1 = previous1;
            }

            if(currentNum2 > previous2) {
                result2 = currentNum2;
            } else {
                result2 = previous2;
            }

            previous1 = currentNum1;
            previous2 = currentNum2;

            result.add(new int[]{result1, result2});

            count++;
        }



        return result;
    }

    public static void main(String[] args) {
        int[] l1 = new int[] { 9, 8, 2 };
        int[] l2 = new int[] { 6, 3, 1 };
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}
