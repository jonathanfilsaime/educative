class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        // TODO: Write your code here
        int firstStart = 0, firstEnd = findPivot(arr);
        while (firstStart <= firstEnd) {
            int mid = firstStart + (firstEnd - firstStart) / 2;
            if(key < arr[mid]) {
                firstEnd = mid - 1;
            } else if (key > arr[mid]) {
                firstStart = mid + 1;
            } else {
                return mid;
            }
        }

        int secondStart = findPivot(arr), secondEnd = arr.length - 1;
        while (secondStart <= secondEnd) {
            int mid = secondStart + (secondEnd - secondStart) / 2;
            if(key < arr[mid]) {
                secondEnd = mid - 1;
            } else if (key > arr[mid]) {
                secondStart = mid + 1;
            } else {
                return mid;
            }
        }


        return -1;
    }

    public static int findPivot(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end ) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}