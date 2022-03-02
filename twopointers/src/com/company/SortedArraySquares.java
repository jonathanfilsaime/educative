package com.company;

import java.util.Arrays;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            squares[i] = (int)Math.pow(arr[i], 2);
        }
        Arrays.sort(squares);
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3})));
        System.out.println(Arrays.toString(SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2})));
    }
}
