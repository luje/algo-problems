package org.home.ace.day7;

public class PathSum3 {

    public int pathSum(TreeNode root, long targetSum) {
        return pathSumP(root, targetSum) + df(root, targetSum);
    }

    public int pathSumP(TreeNode root, long targetSum) {
        if (root == null)
            return 0;

        return (targetSum == root.val ? 1 : 0)
                + pathSumP(root.left, targetSum - root.val)
                + pathSumP(root.right, targetSum - root.val);
    }

    public int df(TreeNode node, long targetSum) {
        return node == null ? 0 :
                pathSumP(node.left, targetSum)
                        + pathSumP(node.right, targetSum)
                        + df(node.left, targetSum)
                        + df(node.right, targetSum);
    }

    public static void main(String[] args) {
        PathSum3 solver = new PathSum3();

        System.out.println(solver.pathSum(
                new TreeNode(1000000000,
                       new TreeNode(1000000000,
                               new TreeNode(294967296,
                                       new TreeNode(1000000000,
                                               new TreeNode(1000000000,
                                                       new TreeNode(1000000000),
                                                       null),
                                               null),
                                       null),
                               null),
                        null
                ),
                0
        ));

//        System.out.println(solver.pathSum(
//                new TreeNode(1,
//                        new TreeNode(-2,
//                                new TreeNode(1,
//                                        new TreeNode(-1),
//                                        null),
//                                new TreeNode(3)),
//                        new TreeNode(-3,
//                                new TreeNode(-2),
//                                null)
//                ),
//                -1
//        ));

//        System.out.println(solver.pathSum(
//                new TreeNode(10,
//                        new TreeNode(5,
//                                new TreeNode(3,
//                                        new TreeNode(3),
//                                        new TreeNode(-2)),
//                                new TreeNode(2,
//                                        null,
//                                        new TreeNode(1))),
//                        new TreeNode(-3,
//                                null,
//                                new TreeNode(11))
//                ),
//                8
//        ));
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
    }
}
