package com.company;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0, smallestLength = Integer.MAX_VALUE, sum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            while(sum >= S) {
                smallestLength = Math.min(smallestLength, windowEnd - windowStart + 1);
                sum -= arr[windowStart];
                windowStart++;
            }

        }
        return smallestLength;
    }

    public static void main(String[] args) {
        System.out.println(MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        System.out.println(MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        System.out.println(MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
    }
}
