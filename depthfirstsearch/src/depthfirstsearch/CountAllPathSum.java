package depthfirstsearch;

import java.util.*;



class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        // TODO: Write your code here
        if(root == null) return 0;
        List<Integer> path = new LinkedList<>();
        return findAllPaths(root, path, S);
    }

    public static int findAllPaths(TreeNode root, List<Integer> path, int s) {
        if(root == null) return 0;

        path.add(root.val);
        int pathCount = 0, sum = 0;

        ListIterator<Integer> pathIterator = path.listIterator(path.size());
        while (pathIterator.hasPrevious()) {
            sum += pathIterator.previous();
            if (sum == s) {
                pathCount++;
            }
        }

        pathCount += findAllPaths(root.left, path, s);
        pathCount += findAllPaths(root.right, path, s);

        path.remove(path.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
