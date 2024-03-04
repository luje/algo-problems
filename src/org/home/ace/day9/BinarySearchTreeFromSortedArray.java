package org.home.ace.day9;

public class BinarySearchTreeFromSortedArray {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        return (i > j) ? null :
                new TreeNode(
                        nums[(i + j) / 2],
                        sortedArrayToBST(nums, i, (i + j) / 2 - 1),
                        sortedArrayToBST(nums, (i + j) / 2 + 1, j)
                );
    }

    public static void main(String[] args) {
        final BinarySearchTreeFromSortedArray solver = new BinarySearchTreeFromSortedArray();

        System.out.println(solver.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", \n left=" + left +
                    ", \n right=" + right +
                    '}';
        }
    }
}
