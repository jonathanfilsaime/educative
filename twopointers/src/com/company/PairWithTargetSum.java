package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here
        int result = 0;
        int startPointer = 0;
        int endPointer = arr.length - 1;
        while(result != targetSum) {
            if(arr[startPointer] + arr[endPointer] < targetSum) {
                startPointer++;
            } else if (arr[startPointer] + arr[endPointer] > targetSum){
                endPointer--;
            } else {
                result = arr[startPointer] + arr[endPointer];
            }
        }

        return new int[] { startPointer, endPointer };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(PairWithTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6)));
    }

//binary search approach
//    public static int[] search(int[] arr, int targetSum) {
//        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
//        for (int i = 0; i < arr.length; i++) {
//            if (nums.containsKey(targetSum - arr[i]))
//                return new int[] { nums.get(targetSum - arr[i]), i };
//            else
//                nums.put(arr[i], i); // put the number and its index in the map
//        }
//        return new int[] { -1, -1 }; // pair not found
//    }
//
//    public static void main(String[] args) {
//        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
//        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
//        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
//        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
//    }
}
