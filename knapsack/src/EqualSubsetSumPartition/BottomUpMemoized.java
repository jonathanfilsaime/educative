package EqualSubsetSumPartition;

public class BottomUpMemoized {
    public boolean canPartition(int[] num) {
        int n = num.length;
        int sum = 0;
        for(int j : num) sum += j;

        if(sum % 2 != 0) return false;

        sum /= 2;
        boolean[][] dp = new boolean[n][sum + 1];

        for(int i = 0; i < n; i++) dp[i][0] = true;
        for(int s = 0; s <= sum; s++) dp[0][s] = (num[0] == s);

        for(int i = 1 ; i < n; i++) {
            for(int j = 1 ; j <= sum; j++) {

                if(dp[i - 1][j]) {
                    dp[i][j] = dp[i-1][j];
                } else if (j >= num[i]) {
                    dp[i][j] = dp[i-1][j-num[i]];
                }
            }
        }

        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        BottomUpMemoized ps = new BottomUpMemoized();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
