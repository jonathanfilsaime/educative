import java.util.*;

class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());
        for (int currentNum : nums) {
            int n = subsets.size();
            for ( int i  = 0; i < n; i++) {
                //making a copy of the all the existing List<Integer>
                List<Integer> set = new ArrayList<>(subsets.get(i));
                //adding the currentNum to it
                set.add(currentNum);
                //adding the new set (copy) + currentNum to the subsets
                subsets.add(set);
            }
        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}