package com.company;

class FindDuplicate {

    public static int findNumber(int[] nums) {
        boolean cycle = false;
        int result = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i ) {
                int place = nums[i];
                int temp = nums[place];
                if (temp == place) {
                    cycle = true;
                    return nums[i];
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

        return result;
    }
}
