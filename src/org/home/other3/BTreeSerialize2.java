package org.home.other3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BTreeSerialize2 {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            final StringBuilder sb = new StringBuilder();
            final Queue<TreeNode> s = new LinkedList<>();

            s.add(root);

            while (!s.isEmpty()) {
                TreeNode current = s.poll();

                sb.append(current == null ? "$" : current.val);
                sb.append(",");

                if (current != null) {
                    s.add(current.left);
                    s.add(current.right);
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            final StringTokenizer tokenizer = new StringTokenizer(data, ",");
            final Queue<TreeNode> nodes = new LinkedList<>();
            final String first = tokenizer.nextToken();
            final TreeNode root = "$".equals(first) ? null : new TreeNode(Integer.valueOf(first));

            nodes.add(root);
            int i = 1;

            while(tokenizer.hasMoreTokens()) {
                final String v = tokenizer.nextToken();
                final TreeNode node = "$".equals(v) ? null : new TreeNode(Integer.valueOf(v));

                if(node != null) {
                    nodes.add(node);
                }

                if (nodes.peek() != null) {
                    if (i % 2 == 1) {
                        nodes.peek().left = node;
                    } else {
                        nodes.peek().right = node;
                    }
                }

                if (i % 2 == 0) {
                    nodes.poll();
                }

                i++;
            }

            return root;
        }

    }

    public static void main(String[] args) {
        final Codec codec = new Codec();
        final String serialized = codec.serialize(new TreeNode(1,
                new TreeNode(2), new TreeNode(3,
                new TreeNode(4), new TreeNode(5, new TreeNode(6), null))));

        System.out.println(serialized);

        final TreeNode deserialized = codec.deserialize(serialized);

        System.out.println(codec.serialize(deserialized));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "[" + left + ", " + right + "]";
        }
    }
}
