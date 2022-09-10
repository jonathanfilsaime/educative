import java.util.*;

class NodeKth {
    int value;
    int index;

    NodeKth(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        // TODO: Write your code here

        Queue<NodeKth> minHeap = new PriorityQueue<>((a, b) -> matrix[a.index][a.value] - matrix[b.index][b.value]);

        for(int i = 0; i < matrix.length && i <k; i++) {
            minHeap.add(new NodeKth(0, i));
        }

        int count = 0, result = 0;

        while(!minHeap.isEmpty()) {
            NodeKth current = minHeap.poll();
            result = matrix[current.index][current.value];
            if(++count == k) break;

            current.value++;
            if(matrix[current.value].length > current.index) minHeap.add(current);

        }

        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}