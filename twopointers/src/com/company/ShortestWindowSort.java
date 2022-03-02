package com.company;

public class ShortestWindowSort {
    public static int sort(int[] arr) {

        int low = 0; int high = arr.length - 1;

        //first out of place index from the start
        while(low < high && arr[low] <= arr[low + 1]) {
            low++;
        }

        // if the array is sorted
        if (low == arr.length - 1)
            return 0;

        //first out of place index from the end
        while(high > low && arr[high] >= arr[high - 1]) {
            high--;
        }

        //find the smallest value within the out place index
        int smallestValue = Integer.MAX_VALUE, largestValue = Integer.MIN_VALUE;
        for(int k = low; k <= high; k++) {
            smallestValue = Math.min(smallestValue, arr[k]);
            largestValue = Math.max(largestValue, arr[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low - 1] > smallestValue)
            low--;
        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < arr.length - 1 && arr[high + 1] < largestValue)
            high++;

        return high - low + 1;

    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(ShortestWindowSort.sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
    }
}
