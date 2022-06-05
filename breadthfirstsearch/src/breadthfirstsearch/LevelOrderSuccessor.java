package breadthfirstsearch;

import java.util.*;
class LevelOrderSuccessor {
    public static SiblingTreeNode findSuccessor(SiblingTreeNode root, int key) {
        // TODO: Write your code here
        boolean found = false;
        Queue<SiblingTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                SiblingTreeNode currentNode = queue.poll();
                if(found) {
                    return currentNode;
                }
                if(currentNode.val == key) {
                    found = true;
                }

                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        SiblingTreeNode root = new SiblingTreeNode(1);
        root.left = new SiblingTreeNode(2);
        root.right = new SiblingTreeNode(3);
        root.left.left = new SiblingTreeNode(4);
        root.left.right = new SiblingTreeNode(5);

        SiblingTreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
        if (result != null)
            System.out.println(result.val + " ");

        root = new SiblingTreeNode(12);
        root.left = new SiblingTreeNode(7);
        root.right = new SiblingTreeNode(1);
        root.left.left = new SiblingTreeNode(9);
        root.right.left = new SiblingTreeNode(10);
        root.right.right = new SiblingTreeNode(5);

        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");

        result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
    }
}