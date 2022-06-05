package depthfirstsearch;

import java.util.*;



class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findAllPath(root, allPaths, path);
        return compute(allPaths);
    }

    public static int compute(List<List<Integer>> allPaths) {
        int sum = 0;
        for(int i = 0; i < allPaths.size(); i++) {
            double num = 0;
            for (int j = 0; j < allPaths.get(i).size(); j++) {
                double exp = allPaths.get(i).size() - (j + 1);
                double pow = 10;
                num = num + allPaths.get(i).get(j) * Math.pow(pow, exp);
            }
            sum = sum + (int)num;
        }
        return sum;
    }

    public static void findAllPath(TreeNode root, List<List<Integer>> allPaths, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);

        if(root.left == null && root.right == null) {
            allPaths.add(new ArrayList<Integer>(path));
        } else {
            findAllPath(root.left, allPaths, path);
            findAllPath(root.right, allPaths, path);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}