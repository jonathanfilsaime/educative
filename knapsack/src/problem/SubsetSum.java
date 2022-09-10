package problem;

class SubsetSum {
    static int countSubsets(int[] num, int sum) {
        return countSubsetsRecursive(num, sum, 0);
    }

    static int countSubsetsRecursive (int[] num, int sum, int currentIndex) {
       if(sum == 0) return 1;
       if(num.length == 0 || currentIndex >= num.length) return 0;

       int sum1 = 0;

       //pick
       if(num[currentIndex] <= sum) sum1 = countSubsetsRecursive(num, sum - num[currentIndex], currentIndex + 1);
       //exclude
       int sum2 = countSubsetsRecursive(num, sum, currentIndex + 1);

        return sum1 + sum2;
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}