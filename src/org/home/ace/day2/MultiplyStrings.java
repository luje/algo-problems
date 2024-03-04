package org.home.ace.day2;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        return reverse(multiplyReversed(reverse(num1), reverse(num2)));
    }

    public String multiplyReversed(String num1, String num2) {
        String result = "0";

        for (int i = 0; i < num1.length(); i++) {
            int n1 = num1.charAt(i) - '0';

            result = add(result, scalar(num2, n1), i);

            while (result.endsWith("0") && result.length() > 1) {
                result = result.substring(0, result.length() - 1);
            }
        }

        return result;
    }

    public String scalar(String num1, int c) {
        final StringBuilder result = new StringBuilder();
        int overflow = 0;

        for (int i = 0; i < num1.length(); i++) {
            int n1 = num1.charAt(i) - '0';

            result.append((n1 * c + overflow) % 10);

            overflow = (n1 * c + overflow) / 10;
        }

        if (overflow != 0) {
            result.append(overflow);
        }

        return result.toString();
    }

    public String add(String num1, String num2, int offset) {
        final StringBuilder result = new StringBuilder();
        int overflow = 0;

        for (int i = 0; i < Math.max(num1.length(), num2.length() + offset); i++) {
            int n1 = i < num1.length() ? num1.charAt(i) - '0' : 0;
            int n2 = offset <= i && i < num2.length() + offset ? num2.charAt(i - offset) - '0' : 0;

            result.append((n1 + n2 + overflow) % 10);

            overflow = (n1 + n2 + overflow) / 10;
        }

        if (overflow != 0) {
            result.append(overflow);
        }

        return result.toString();
    }

    public String reverse(String num) {
        return new StringBuilder(num).reverse().toString();
    }

    public static void main(String[] args) {
        MultiplyStrings solver = new MultiplyStrings();

        System.out.println(solver.multiply("20", "0"));
        System.out.println(solver.multiply("2", "3"));
        System.out.println(solver.multiply("123", "456"));

        System.out.println((757 + 456) + "=" + solver.reverse(
                solver.add(solver.reverse("757"),
                        solver.reverse("456"), 0))
        );

        System.out.println((757 + 4560) + "=" + solver.reverse(
                solver.add(solver.reverse("757"),
                        solver.reverse("456"), 1))
        );

        System.out.println((757 + 456000) + "=" + solver.reverse(
                solver.add(solver.reverse("757"),
                        solver.reverse("456"), 3))
        );

        System.out.println((757 * 5) + "=" + solver.reverse(
                solver.scalar(solver.reverse("757"),
                        5))
        );
    }

}
