package com.company;

class CyclicSort {

    public static void sort(int[] nums) {
        // TODO: Write your code here
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i ) {
                int place = nums[i] - 1;
                int temp = nums[place];
                nums[place] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
    }
}