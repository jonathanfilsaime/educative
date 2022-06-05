package com.company;

import java.util.*;

class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> numsList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int count = min;
        while(count <= max && missingNumbers.size() < k) {
            System.out.println("count : " + count + " - " + numsList.contains(count));

            if(!numsList.contains(count) && count > 0){
                missingNumbers.add(count);
            }
            count++;
        }

        if(missingNumbers.size() < k) {
            for(int i = 1; missingNumbers.size() < k; i++) {
                if(!numsList.contains(i) && !missingNumbers.contains(i)) {
                    missingNumbers.add(i);
                }
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        for (Integer number : findNumbers(new int[]{-2, -3, 4}, 2)) {
            System.out.println(number);
        }
//        findNumbers(new int[]{2, 3, 4}, 3);
//        findNumbers(new int[]{-2, -3, 4}, 2);

    }
}
