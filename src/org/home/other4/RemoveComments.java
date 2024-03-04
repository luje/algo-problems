package org.home.other4;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-comments/
public class RemoveComments {

    public List<String> removeComments(String[] source) {
        final var result = new ArrayList<String>();

        boolean block = false;
        StringBuilder line = new StringBuilder();

        for (String sc : source) {
            line = block ? line : new StringBuilder();

            for (int i = 0; i < sc.length(); i++) {
                if (block) {
                    if (i > 0 && sc.charAt(i - 1) == '*' && sc.charAt(i) == '/') {
                        block = false;
                    }

                    continue;
                }

                if (sc.charAt(i) == '/') {
                    if (i + 1 < sc.length() && sc.charAt(i + 1) == '*') {
                        i += 2;
                        block = true;

                        continue;
                    }

                    if (i + 1 < sc.length() && sc.charAt(i + 1) == '/') {
                        break;
                    }
                }

                line.append(sc.charAt(i));
            }

            if ((!line.isEmpty()) && !block) {
                result.add(line.toString());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final var solver = new RemoveComments();

        System.out.println(solver.removeComments(new String[]{"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"}));
        System.out.println(solver.removeComments(new String[]{"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"}));

        System.out.println(solver.removeComments("""
                a/*comment
                line
                more_comment*/b
                """.split("\n")));

        System.out.println(solver.removeComments("""
                /*Test program */
                int main()
                {\s
                  // variable declaration\s
                int a, b, c;
                /* This is a test
                   multiline \s
                   comment for\s
                   testing */
                a = b + c;
                }
                The string /* denotes a block comment, including line 1 and lines 6-9. The string // denotes line 4 as comments.
                The line by line output code is visualized as below:
                int main()
                {\s
                 \s
                int a, b, c;
                a = b + c;
                }
                """.split("\n")));

    }
}
