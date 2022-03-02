package com.company;

import java.util.*;

class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
       Arrays.sort(arr);
       List<List<Integer>> quadruplets = new ArrayList<>();
       for(int first = 0; first < arr.length - 3; first++) {
           if(first > 0 && arr[first] == arr[first - 1]) {
               continue;
           }
           for(int second = first + 1; second < arr.length -2; second++) {
               if(second > first + 1 && arr[second] == arr[second - 1]) {
                   continue;
               }

               findUniqueQuadruplet(arr, first, second, target, quadruplets);
           }
       }

       return quadruplets;
    }

    public static void findUniqueQuadruplet(int[] arr, int first, int second, int target, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = arr.length - 1;

        while(left < right) {
            int sum = arr[first] + arr[second] + arr[left] + arr[right];
            if(sum == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while(left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if ( sum < target) {
                    left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}