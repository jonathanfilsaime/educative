package com.company;

class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0;
            int fastPointer = i, slowPointer = i;
            do {
                slowPointer = findNextIndex(arr, isForward, slowPointer);
                fastPointer = findNextIndex(arr, isForward, fastPointer);
                if (fastPointer != -1) {
                    fastPointer = findNextIndex(arr, isForward, fastPointer);
                }
            } while (slowPointer != -1 && fastPointer != -1 && slowPointer != fastPointer);

            if(slowPointer != -1 && slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        //change of direction
        if(isForward != (arr[currentIndex] > 0)) {
            return -1;
        }

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;

        //one element cycle
        if(nextIndex == currentIndex) {
            return -1;
        }

        // wrap around for negative numbers
        if (nextIndex < 0) {
            nextIndex += arr.length;
        }

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
