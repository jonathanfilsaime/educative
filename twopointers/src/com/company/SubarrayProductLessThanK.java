package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        int left = 0, product = 1;
        List<List<Integer>> subArray = new ArrayList<>();
        for(int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while(product >= target && left < arr.length) {
                product /= arr[left];
                left++;
            }

            List<Integer> integerList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                integerList.add(0, arr[i]);
                subArray.add(new ArrayList<>(integerList));
            }
        }
        return subArray;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
