package EqualSubsetSumPartition;

class BruteForce {

    public boolean canPartition(int[] num) {
        int sum = 0;

        for (int j : num) sum += j;

        if (sum % 2 != 0) return false;

        return this.canPartitionRecursive(num, sum/2, 0);
    }

    public boolean canPartitionRecursive (int[] num, int sum, int currentIndex) {
        if(sum == 0) return true;

        if(currentIndex >= num.length || num.length == 0) return false;

        //pick
        if(num[currentIndex] <= sum) {
            if(canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)) return true;
        }

        //exclude
        return canPartitionRecursive(num, sum, currentIndex + 1);
    }

    public static void main(String[] args) {
        BruteForce ps = new BruteForce();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}