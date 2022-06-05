package com.company;

class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        // TODO: Write your code here
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i && nums[i] < nums.length) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
                i--;
            }
        }

        for(int i = 0; i <nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findMissingNumber(new int[]{4,3,1,0});
    }
}
