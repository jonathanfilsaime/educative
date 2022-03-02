package com.company;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        // TODO: Write your code here
        Map<Integer, Integer> frequency = new HashMap<>();
        for( int i = 0; i < arr.length; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
        }

        return frequency.size();
    }

    public static void main(String[] args) {
        System.out.println(RemoveDuplicates.remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println(RemoveDuplicates.remove(new int[]{2, 2, 2, 11}));
    }
}
