package com.company;

import java.util.*;

class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        boolean cycle = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i ) {
                int place = nums[i] - 1;
                int temp = nums[place];
                if (temp - 1 == place) {
                    cycle = true;
                } else {
                    cycle = false;
                }
                nums[place] = nums[i];
                nums[i] = temp;
                if (!cycle) {
                    i--;
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}