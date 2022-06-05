package com.company;

class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {
        // TODO: Write your code here
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

        int first = -1;
        int second = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                first = nums[i];
                second = i + 1;
            }
        }
        return new int[] { first, second };
    }

    public static void main(String[] args) {
        int[] result = findNumbers(new int[]{3, 1, 2, 5, 2});
        System.out.println(result[0] + "-" + result[1]);
    }
}
