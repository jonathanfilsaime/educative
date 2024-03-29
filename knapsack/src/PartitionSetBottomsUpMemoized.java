public class PartitionSetBottomsUpMemoized {
    public int canPartition(int[] num) {

        int sum = 0;
        for(int i = 0; i < num.length; i++) sum += num[i];

        int n = num.length;
        boolean[][] dp = new boolean[n][sum/2 + 1];

        for(int i = 0; i < n; i++) dp[i][0] = true;
        for(int i = 1; i <= sum/2; i++) dp[0][i] = (num[0] == i);

        for(int i = 1; i < num.length; i++) {
            for(int j = 1; j <= sum/2; j++) {
                if(dp[i-1][j]) {
                    dp[i][j] = dp[i-1][j];
                } else if (j >= num[i]) {
                    dp[i][j] = dp[i-1][j - num[i]];
                }
            }
        }

        int sum1 = 0;
        // Find the largest index in the last row which is true
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n - 1][i]) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum2-sum1);
    }

    public static void main(String[] args) {
        PartitionSetBottomsUpMemoized ps = new PartitionSetBottomsUpMemoized();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
