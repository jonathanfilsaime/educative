class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length + 1][capacity + 1];
        return this.knapsack(dp, profits, weights, capacity, 0);
    }

    public int knapsack(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        //base case
        if(currentIndex >= profits.length || capacity <= 0) {
            return 0;
        }

        if(dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }

        int profit1 = 0;

        if(weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsack(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        int profit2 = knapsack(dp, profits, weights, capacity, currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];

    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}