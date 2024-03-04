package codility;

public class BitSmth {

    public int solution(int A, int B, int C) {
        // Implement your solution here
        return pow2(d(A)) + pow2(d(B)) + pow2(d(C))
                - pow2(d(A|B)) - pow2(d(A|C)) - pow2(d(B|C))
                + pow2(d(A|B|C));
    }

    public int pow2(int n) {
        return 1 << n;
    }

    public int d(int A) {
        int working = A;
        int count = 0;

        for (int i = 0; i < 30; i++) {
            if (working % 2 == 0) {
                count++;
            }

            working = working / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        var solver = new BitSmth();

        System.out.println(solver.solution(
                Integer.valueOf("111111111111111111111110001111", 2),
                Integer.valueOf("111111111111111111111111100011", 2),
                Integer.valueOf("111111111111111111111111111000", 2)
        ));
        System.out.println(solver.solution(
                Integer.valueOf("111111111111111111111111001111", 2),
                Integer.valueOf("111111111111111111111111110011", 2),
                Integer.valueOf("111111111111111111111111111100", 2)
        ));
        System.out.println(solver.solution(
                Integer.valueOf("000000000000000000000000000000", 2),
                Integer.valueOf("111111111111111111111111111111", 2),
                Integer.valueOf("111111111111111111111111111111", 2)
        ));
        System.out.println(solver.solution(
                Integer.valueOf("111111111111111111111111110011", 2),
                Integer.valueOf("111111111111111111111111111001", 2),
                Integer.valueOf("111111111111111111111111111100", 2)
        ));
        System.out.println(solver.solution(
                Integer.valueOf("111111111111111111111100111111", 2),
                Integer.valueOf("111111111111111111111111001111", 2),
                Integer.valueOf("111111111111111111111111111100", 2)
        ));
        System.out.println(solver.solution(
                Integer.valueOf("111111111111111111111100111111", 2),
                Integer.valueOf("111111111111111111111100111111", 2),
                Integer.valueOf("111111111111111111111100111111", 2)
        ));
        System.out.println(solver.solution(1_073_741_727, 1_073_741_631, 1_073_741_679));

        System.out.println("-------------");
        System.out.println(solver.d(1_073_741_727));
        System.out.println(solver.d(1_073_741_631));
        System.out.println(solver.d(1_073_741_679));
    }

}
