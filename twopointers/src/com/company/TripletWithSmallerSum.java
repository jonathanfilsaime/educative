package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int right = arr.length - 1;
        Arrays.sort(arr);
        int count = 0;
        for(int index = 0; index < arr.length - 2; index++) {
            int left = index + 1;
            while(left < right ) {
                int sum = arr[index] + arr[left] + arr[right];
                if (target > sum && (index != left) && (left != right)) {
                    count += right - left; //I'm not sure why this works
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
