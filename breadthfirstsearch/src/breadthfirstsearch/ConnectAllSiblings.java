package breadthfirstsearch;

import java.util.*;

class TreeNodeSiblingsConnected {
    int val;
    TreeNodeSiblingsConnected left;
    TreeNodeSiblingsConnected right;
    TreeNodeSiblingsConnected next;

    TreeNodeSiblingsConnected(int x) {
        val = x;
        left = right = next = null;
    }
};

class ConnectAllSiblings {
    public static void connect(TreeNodeSiblingsConnected root) {
        // TODO: Write your code here
        if(root == null) return;
        Queue<TreeNodeSiblingsConnected> queue = new LinkedList<>();
        queue.add(root);
        TreeNodeSiblingsConnected previous = null;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNodeSiblingsConnected currentNode = queue.poll();

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
        TreeNodeSiblingsConnected root = new TreeNodeSiblingsConnected(12);
        root.left = new TreeNodeSiblingsConnected(7);
        root.right = new TreeNodeSiblingsConnected(1);
        root.left.left = new TreeNodeSiblingsConnected(9);
        root.right.left = new TreeNodeSiblingsConnected(10);
        root.right.right = new TreeNodeSiblingsConnected(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNodeSiblingsConnected current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
