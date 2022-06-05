package breadthfirstsearch;

import java.util.*;

class LevelAverage {
    public static List<Double> findLevelAverages(SiblingTreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<SiblingTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double values = 0;

            for (int i = 0; i < levelSize; i++) {
                SiblingTreeNode currentNode = queue.poll();
                values += currentNode.val;
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }

            result.add((values/levelSize));
        }
        return result;
    }

    public static void main(String[] args) {
        SiblingTreeNode root = new SiblingTreeNode(12);
        root.left = new SiblingTreeNode(7);
        root.right = new SiblingTreeNode(1);
        root.left.left = new SiblingTreeNode(9);
        root.left.right = new SiblingTreeNode(2);
        root.right.left = new SiblingTreeNode(10);
        root.right.right = new SiblingTreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}