package codility;

public class StringGen {

    public String solution(int A, int B) {
        if (A == 0) {
            return mul("b", B);
        } else if (B == 0) {
            return mul("a", A);
        } else if (A == B) {
            return mul("ab", A);
        } else if (A > B) {
            return "aab" + solution(A - 2, B - 1);
        } else {
            return "bba" + solution(A - 1, B - 2);
        }
    }

    public String mul(String x, int n) {
        if (n == 0)
            return "";

        if (n == 1)
            return x;

        return n % 2 == 0 ?
                mul(x + x, n / 2) :
                x + mul(x, n - 1);
    }

    public static void main(String[] args) {
        var solver = new StringGen();

        System.out.println(solver.solution(5, 4));
        System.out.println(solver.solution(4, 5));
        System.out.println(solver.solution(3, 3));
        System.out.println(solver.solution(1, 4));
    }
}
