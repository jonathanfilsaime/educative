class TwoSingleNumbers {

    public static int[] findSingleNumbers(int[] nums) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for(int num: nums) {
            n1xn2 = n1xn2 ^ num;
        }

        int rightMostSetBit = 1;
        while((rightMostSetBit & n1xn2) == 0) {
            rightMostSetBit = rightMostSetBit << 1;
        }

        int num1 = 0, num2 = 0;
        for(int num: nums) {
            if((num & rightMostSetBit) != 0) {
                num1 = num1 ^ num;
            } else {
                num2 = num2 ^ num;
            }
        }


        return new int[] { num1, num2 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}