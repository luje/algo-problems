package org.home.other4;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return eq(root, subRoot) || (root != null && isSubtree(root.left, subRoot)) || (root != null && isSubtree(root.right, subRoot));
    }

    public boolean eq(TreeNode root, TreeNode other) {
        return (root == null && other == null) ||
                (root != null && other != null && root.val == other.val && eq(root.left, other.left) && eq(root.right, other.right));
    }

    public static void main(String[] args) {
        final var solver = new SubtreeOfAnotherTree();

        System.out.println(
                solver.isSubtree(
                        new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5)),
                        new TreeNode(4, new TreeNode(1), new TreeNode(2))
                )
        );

        System.out.println(
                solver.isSubtree(
                        new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5)),
                        new TreeNode(4, new TreeNode(1), new TreeNode(2))
                )
        );
    }

    //  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
