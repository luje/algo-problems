package org.home.other4;

// https://leetcode.com/problems/valid-parenthesis-string/
public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int h = 0;
        int l = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
                h++;
            } else if (c == ')') {
                l--;
                h--;
            } else {
                l --;
                h ++;
            }

            l = Math.max(l, 0);

            if(h < 0)
                return false;
        }

        return l == 0;
    }

    public static void main(String[] args) {
        final var solver = new ValidParenthesisString();

        System.out.println("true = " + solver.checkValidString("(*)"));
        System.out.println("-------------------");
        System.out.println("false = " + solver.checkValidString(")()"));
        System.out.println("-------------------");
        System.out.println("true = " + solver.checkValidString("()"));
        System.out.println("-------------------");
        System.out.println("true = " + solver.checkValidString("(*))"));
        System.out.println("-------------------");
        System.out.println("false = " + solver.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
        System.out.println("-------------------");
    }
}
