package breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

class SiblingTreeNode {
    int val;
    SiblingTreeNode left;
    SiblingTreeNode right;
    SiblingTreeNode next;

    SiblingTreeNode(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        SiblingTreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            SiblingTreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(SiblingTreeNode root) {
        // TODO: Write your code here
        if(root == null) return;

        Queue<SiblingTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            SiblingTreeNode previous = null;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                SiblingTreeNode currentNode = queue.poll();

                if(previous != null) {
                    previous.next = currentNode;
                }
                previous = currentNode;

                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        SiblingTreeNode root = new SiblingTreeNode(12);
        root.left = new SiblingTreeNode(7);
        root.right = new SiblingTreeNode(1);
        root.left.left = new SiblingTreeNode(9);
        root.right.left = new SiblingTreeNode(10);
        root.right.right = new SiblingTreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}