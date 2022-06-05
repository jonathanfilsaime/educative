package com.company;

class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {
        // TODO: Write your code here
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i && nums[i] > 0) {
                if(nums[i] < nums.length) {
                    int place = nums[i] - 1;
                    int temp = nums[place];
                    nums[place] = nums[i];
                    nums[i] = temp;
                    i--;
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return nums[i-1] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{3, 2, 5, 1}));
        System.out.println(findNumber(new int []{-3, 1, 5, 4, 2}));
        System.out.println(findNumber(new int[]{3, -2, 0, 1, 2}));
    }
}
