package EqualSubsetSumPartition;

public class TopDownMemoized {

    public boolean canPartition(int[] num) {

        int sum = 0;
        for (int j : num) sum += j;

        if(sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];

        return canPartitionRecursive(dp, num, sum/2, 0);
    }

    public boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
        if (sum == 0) return true;

        if (currentIndex >= num.length || num.length == 0) return false;


        if (dp[currentIndex][sum] == null) {

            //pick
            if(num[currentIndex] <= sum) {
                if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }

            //exclude
            dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
        }

        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        TopDownMemoized ps = new TopDownMemoized();
        int[] num = { 1, 2, 3, 4 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(ps.canPartition(num));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(ps.canPartition(num));
    }
}
