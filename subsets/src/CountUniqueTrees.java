import java.util.*;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//};

class CountUniqueTrees {
    public int countTrees(int n) {
        // TODO: Write your code here
        if (n <= 0) return 0;

        return findUniqueTree(1, n).size();
    }

    public List<TreeNode> findUniqueTree(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end ) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = findUniqueTree(start, i- 1);
            List<TreeNode> rightSubTree = findUniqueTree(i + 1, end);

            for(TreeNode leftNode: leftSubTree) {
                for(TreeNode rightNode: rightSubTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    result.add(node);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(2);
        System.out.print("Total trees: " + count);
    }
}