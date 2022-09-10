import java.util.*;

class NodeMSorted {
    int value;
    int index;

    NodeMSorted(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        // TODO: Write your code here
        PriorityQueue<NodeMSorted> minHeap = new PriorityQueue<>((a, b) -> lists.get(a.index)[a.value] - lists.get(b.index)[b.value]);

        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null) minHeap.add(new NodeMSorted(0, i));
        }

        int count = 0, result = 0;

        while(!minHeap.isEmpty()) {
            NodeMSorted current = minHeap.poll();
            result = lists.get(current.index)[current.value];
            if(++count == k) break;

            current.value++;
            if(lists.get(current.value).length > current.index) minHeap.add(current);

        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}