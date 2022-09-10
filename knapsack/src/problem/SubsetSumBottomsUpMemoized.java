package problem;

class SubsetSumBottomsUpMemoized {
    static int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        for(int i = 0; i < n; i++) dp[i][0] = 1;
        for(int i = 1; i <= sum; i++) dp[0][i] = (num[0] == i ? 1 : 0);

        for(int i = 1; i < num.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num[i]) {
                    dp[i][j] += dp[i - 1][j - num[i]];
                }
            }
        }

        return dp[num.length - 1][sum];
    }

    public static void main(String[] args) {
        SubsetSumBottomsUpMemoized ss = new SubsetSumBottomsUpMemoized();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
