package com.company;

import java.util.*;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for(int target = 0; target < arr.length - 2; target++) {
            if (target > 0 && arr[target] == arr[target - 1]) continue;
            searchTriplets(arr, -arr[target], target + 1, triplets);
        }
        return triplets;
    }

    public static void searchTriplets(int[] arr, int target, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while(left < right) {
            if (target == arr[left] + arr[right]) {
                triplets.add(Arrays.asList(-target, arr[left], arr[right]));
                left++;
                right--;
            } else if (target > arr[left] + arr[right]) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
