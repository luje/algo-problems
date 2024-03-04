package codility;

public class TreeZigZag {
    public int solution(Tree T) {
        return Math.max(0,
                Math.max(
                        solution(T.l, "L"),
                        solution(T.r, "R")
                )
        );
    }

    public int solution(Tree T, String d) {
        if (T == null)
            return -1;

        return Math.max(
                (d.equals("R") ? 1 : 0) + solution(T.l, "L"),
                (d.equals("L") ? 1 : 0) + solution(T.r, "R")
        );
    }

    public static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int x) {
            this.x = x;
        }

        public Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        var solver = new TreeZigZag();


        System.out.println(solver.solution(
                        new Tree(1,
                                new Tree(2,
                                        new Tree(4,
                                                null,
                                                new Tree(5)),
                                        new Tree(3,
                                                new Tree(6),
                                                null)
                                ),
                                new Tree(2,
                                        new Tree(3),
                                        null)
                        )
                )
        );

        System.out.println(solver.solution(
                        new Tree(1,
                                new Tree(2, null, new Tree(3)),
                                null)
                )
        );

        System.out.println(solver.solution(
                        new Tree(1,
                                new Tree(2),
                                null)
                )
        );

        System.out.println(solver.solution(new Tree(1)));

        System.out.println(
                solver.solution(
                        new Tree(5,
                                new Tree(3,
                                        new Tree(20,
                                                new Tree(6),
                                                null),
                                        null),
                                new Tree(10,
                                        new Tree(1),
                                        new Tree(15,
                                                new Tree(30,
                                                        null,
                                                        new Tree(9)
                                                ),
                                                new Tree(8)
                                        )
                                )
                        )
                )
        );
    }
}
