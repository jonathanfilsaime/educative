package com.company;

import java.util.Arrays;

public class DutchFlag {
    public static void sort(int[] arr) {
        // TODO: Write your code here
        int numberOfSwap = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i]  < arr[i- 1]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
                numberOfSwap++;
            }

            if(i == arr.length - 1 && numberOfSwap != 0) {
                i = 0;
                numberOfSwap = 0;
            }

            if (i == arr.length - 1 && numberOfSwap == 0) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        DutchFlag.sort(new int[]{1, 0, 2, 1, 0});
        DutchFlag.sort(new int[]{2, 2, 0, 1, 2, 0});
    }
}
