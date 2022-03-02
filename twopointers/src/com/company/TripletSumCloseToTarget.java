package com.company;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        int closestSum = Integer.MAX_VALUE;
        int right = arr.length - 1;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;

            while(left < right) {
                int diff = targetSum - arr[i] - arr[left] - arr[right];
                if (diff == 0) return diff;
                if (Math.abs(diff) < Math.abs(closestSum) || (Math.abs(diff) == Math.abs(closestSum) && diff > closestSum))
                    closestSum = diff;
                if (diff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
            }
        }
        return targetSum - closestSum;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}
