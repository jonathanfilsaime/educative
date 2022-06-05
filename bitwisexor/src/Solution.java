class Solution {
    public static int[][] flipAndInvertImage(int[][] arr) {
        //TODO: Write your code here
        int length = arr[0].length;
        for(int[] row: arr) {
            for (int i = 0; i < (length + 1) / 2; ++i) {
                int temp = row[i] ^ 1;
                row[i] = row[length - 1 - i] ^ 1;
                row[length - 1 - i] = temp;
            }
        }

        return arr;
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }
}