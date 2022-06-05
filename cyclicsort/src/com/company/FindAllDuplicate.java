package com.company;

import java.util.*;

class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
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
                duplicateNumbers.add(nums[i]);
            }
        }
        return duplicateNumbers;
    }
}
