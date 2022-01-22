package com.company;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowStart = 0, maxSum = Integer.MIN_VALUE, sum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            if (windowEnd - windowStart + 1 > k) {
                sum -= arr[windowStart];
                windowStart++;
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}
