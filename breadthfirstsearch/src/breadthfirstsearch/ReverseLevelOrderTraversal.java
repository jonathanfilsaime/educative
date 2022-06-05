package breadthfirstsearch;

import java.util.*;
class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(SiblingTreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        Queue<SiblingTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                SiblingTreeNode node = queue.poll();
                currentLevel.add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(0, currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        SiblingTreeNode root = new SiblingTreeNode(12);
        root.left = new SiblingTreeNode(7);
        root.right = new SiblingTreeNode(1);
        root.left.left = new SiblingTreeNode(9);
        root.right.left = new SiblingTreeNode(10);
        root.right.right = new SiblingTreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
