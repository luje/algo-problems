package org.home.other4;

// https://leetcode.com/problems/solve-the-equation
// horrible
public class SolveEquation {

    public String solveEquation(String equation) {
        final var split = equation.split("=");

        int[] l = simplify(split[0]);
        int[] r = simplify(split[1]);

        return (l[0] - r[0]) == 0 ?
                (-l[1] + r[1] == 0) ?
                        "Infinite solutions" :
                        "No solution" :
                "x=" + ((-l[1] + r[1]) / (l[0] - r[0]));
    }

    public int[] simplify(String eq) {
        var result = new int[2];

        Integer coef = null;
        var sign = 1;

        for (int i = 0; i < eq.length(); i++) {
            var c = eq.charAt(i);

            if (c == 'x') {
                coef = coef == null ? 1 : coef;
                result[0] += (sign == -1 && coef == 0) ? -1 : sign * coef;
                coef = 0;
            } else if (c == '-' || c == '+') {
                result[1] += sign * (coef == null ? 0 : coef);
                coef = null;
                sign = c == '-' ? -1 : 1;
            } else if (i == eq.length() - 1) {
                coef = (coef == null ? 0 : coef) * 10 + (c - '0');
                result[1] += sign * coef;
                coef = null;
            } else {
                coef = (coef == null ? 0 : coef) * 10 + (c - '0');
            }
        }

        return result;
    }


    public static void main(String[] args) {
        final var solver = new SolveEquation();

        System.out.println("x=1 : " + solver.solveEquation("1+x=2"));
        System.out.println("x=1 : " + solver.solveEquation("-x=-1"));
        System.out.println("Infinite solutions : " + solver.solveEquation("0x=0"));
        System.out.println("x=-1 : " + solver.solveEquation("2x+3x-6x=x+2"));
        System.out.println("x=2 : " + solver.solveEquation("x+5-3+x=6+x-2"));
        System.out.println("x=1 : " + solver.solveEquation("-x=-1"));
        System.out.println("Infinite solutions : " + solver.solveEquation("x=x"));
        System.out.println("x=0 : " + solver.solveEquation("2x=x"));
        System.out.println("No solution : " + solver.solveEquation("x=x+2"));
    }
}
