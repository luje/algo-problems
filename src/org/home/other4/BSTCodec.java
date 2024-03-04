package org.home.other4;

public class BSTCodec {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";

            final StringBuilder sb = new StringBuilder();

            sb.append(root.val);

            String left = serialize(root.left);
            String right = serialize(root.right);

            sb.append(" ");
            sb.append(left.length());
            sb.append(" ");
            sb.append(left);
            sb.append(right);

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.trim().isEmpty())
                return null;

            int di = data.indexOf(" ");
            int val = Integer.parseInt(data.substring(0, di));

            int lli = data.indexOf(" ", di + 1);
            int ll = Integer.parseInt(data.substring(di + 1, lli)) + 1;

            TreeNode result = new TreeNode(val);

            result.left = deserialize(data.substring(lli + 1, lli + ll));
            result.right = deserialize(data.substring(lli + ll));

            return result;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(root);

        System.out.println(tree);

        TreeNode ans = deser.deserialize(tree);

        System.out.println(ans);
    }
}
