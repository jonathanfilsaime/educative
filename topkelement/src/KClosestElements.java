import java.util.*;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {

        int index = binarysearch(arr, X);
        int low = Math.max(index - K, 0);
        int high = Math.min(arr.length - 1, index + K);

        PriorityQueue<Entry> minHeap = new PriorityQueue<>((a, b) -> a.key - b.key);

        for(int i = low; i <= high; i++) {
            minHeap.add(new Entry(Math.abs(arr[i] - X), i));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++)
            result.add(arr[minHeap.poll().value]);

        Collections.sort(result);
        return result;
    }

    public static int binarysearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        if(low > 0) return low - 1;
        return low;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}