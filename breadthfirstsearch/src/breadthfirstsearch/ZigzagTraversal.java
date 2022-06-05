package breadthfirstsearch;

import java.util.*;
class ZigzagTraversal {
    public static List<List<Integer>> traverse(SiblingTreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<SiblingTreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigZag = true;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> current = new ArrayList<>(queue.size());
            for (int i = 0; i < levelSize ; i++) {
                SiblingTreeNode currentNode = queue.poll();

                if(zigZag){
                    current.add(currentNode.val);
                } else {
                    current.add(0, currentNode.val);
                }

                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
            zigZag =! zigZag;
            result.add(current);
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
        root.right.left.left = new SiblingTreeNode(20);
        root.right.left.right = new SiblingTreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
