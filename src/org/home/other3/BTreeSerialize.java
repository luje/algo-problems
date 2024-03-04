package org.home.other3;

import java.util.Stack;

public class BTreeSerialize {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return root == null ? "()" : root.val + "(" + serialize(root.left) + ", " + serialize(root.right) + ")";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            if (data.equals("()")) return null;

            final int split1 = data.indexOf("(");

            final int num = Integer.valueOf(data.substring(0, split1));
            final String rest = data.substring(split1 + 1, data.length() - 1);

            final int split2 = find(rest);

            final TreeNode result = new TreeNode(num);

            if(split2 == -1) {
                return result;
            }

            result.left = deserialize(rest.substring(0, split2).trim());
            result.right = deserialize(rest.substring(split2 + 2).trim());

            return result;
        }

        private int find(String rest) {
            final Stack<Character> s = new Stack<>();

            for(int i = 0; i < rest.length(); i++) {
                char c = rest.charAt(i);

                if(c != '(' && c != ')')
                    continue;

                if(c == ')' && s.peek() == '(')
                    s.pop();
                else s.push(c);

                if( i > 0 && s.isEmpty())
                    return i + 1;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        final Codec codec = new Codec();
        final String serialized = codec.serialize(new TreeNode(1,
                null, new TreeNode(2)));

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
    }
}
