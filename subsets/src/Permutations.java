import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutation = new LinkedList<>();
        permutation.add(new ArrayList<>());
        for ( int num : nums) {
            int n = permutation.size();

            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutation.poll();

                for(int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, num);

                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutation.add(newPermutation);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}