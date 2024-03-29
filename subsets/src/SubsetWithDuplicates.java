import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        Arrays.sort(nums);
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            //skip if same
            if(i > 0 && nums[i] == nums[i-1]) startIndex = endIndex + 1;

            endIndex = subsets.size();

            for (int j = startIndex; j < endIndex; j++) {
                List<Integer> sub = new ArrayList<>(subsets.get(j));
                sub.add(nums[i]);
                subsets.add(sub);
            }

        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}