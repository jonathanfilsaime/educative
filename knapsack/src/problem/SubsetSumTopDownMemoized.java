package problem;

class SubsetSumTopDownMemoized {
    static int countSubsets(int[] num, int sum) {
        Integer[][] dp = new Integer[num.length][sum + 1];
        return countSubsetsRecursive(dp, num, sum, 0);
    }

    static int countSubsetsRecursive (Integer[][] dp, int[] num, int sum, int currentIndex) {
        if(sum == 0) return 1;
        if(num.length == 0 || currentIndex >= num.length) return 0;

        int sum1 = 0;
        if(dp[currentIndex][sum] == null) {
            //pick
            if(num[currentIndex] <= sum) sum1 = countSubsetsRecursive(dp, num, sum - num[currentIndex], currentIndex + 1);
            //exclude
            int sum2 = countSubsetsRecursive(dp, num, sum, currentIndex + 1);

            dp[currentIndex][sum] = sum1 + sum2;
        }


        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        SubsetSumTopDownMemoized ss = new SubsetSumTopDownMemoized();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}