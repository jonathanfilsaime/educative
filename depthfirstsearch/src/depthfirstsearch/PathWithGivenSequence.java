package depthfirstsearch;

import java.util.*;

class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null) return sequence.length == 0;
        return findAllPaths(root, sequence, 0);
    }

    public static boolean findAllPaths(TreeNode root, int[] sequence, int sequenceIndex) {
        if(root ==  null) return false;
        if(sequenceIndex > sequence.length || root.val != sequence[sequenceIndex]) return false;
        if (root.left == null && root.right == null && sequenceIndex == sequence.length - 1) return true;

        return findAllPaths(root.left, sequence, sequenceIndex + 1) ||
                findAllPaths(root.right, sequence, sequenceIndex + 1);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}