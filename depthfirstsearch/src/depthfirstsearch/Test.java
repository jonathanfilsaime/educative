package depthfirstsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void compute(List<List<Integer>> allPaths) {

        int[] tst = new int[]{0,1,2};
        for(int i = 0; i < allPaths.size(); i++) {
            System.out.println(Arrays.toString(tst));
            System.out.println(allPaths.get(i).toString());
            if(Arrays.toString(tst).equals(allPaths.get(i).toString())) {
                System.out.println("true");
            }
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> allPaths = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            List<Integer> path = new ArrayList<>();
            for(int j = 0; j < 3; j++) {
                path.add(j);
            }
            allPaths.add(path);
        }

        compute(allPaths);
    }
}
