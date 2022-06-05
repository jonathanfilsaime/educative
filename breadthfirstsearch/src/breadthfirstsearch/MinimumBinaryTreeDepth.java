package breadthfirstsearch;

import java.util.*;
class MinimumBinaryTreeDepth {
    public static int findDepth(SiblingTreeNode root) {
        // TODO: Write your code here
        Queue<SiblingTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                SiblingTreeNode currentNode = queue.poll();
                if (currentNode.right == null && currentNode.left == null) {
                    return depth;
                }
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        SiblingTreeNode root = new SiblingTreeNode(12);
        root.left = new SiblingTreeNode(7);
        root.right = new SiblingTreeNode(1);
        root.right.left = new SiblingTreeNode(10);
        root.right.right = new SiblingTreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new SiblingTreeNode(9);
        root.right.left.left = new SiblingTreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
