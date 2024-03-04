package org.home.leetcode.contestbi119;

// https://leetcode.com/contest/biweekly-contest-119/problems/remove-adjacent-almost-equal-characters/
public class RemoveAdjacentCharacters {

    public int removeAlmostEqualCharacters(String word) {
        return removeAlmostEqualCharacters(word, 0);
    }

    public int removeAlmostEqualCharacters(String word, int start) {
        if(word.length() - start < 2) return 0;

        var a = word.charAt(start);
        var b = word.charAt(start + 1);

        return (Math.abs(a - b) < 2) ?
                1 + removeAlmostEqualCharacters(word, start + 2) :
                removeAlmostEqualCharacters(word, start + 1);
    }

    public static void main(String[] args) {
        var solver = new RemoveAdjacentCharacters();

        System.out.println("1 = " + solver.removeAlmostEqualCharacters("acb"));
        System.out.println("2 = " + solver.removeAlmostEqualCharacters("aaaaa"));
        System.out.println("2 = " + solver.removeAlmostEqualCharacters("abddez"));
        System.out.println("3 = " + solver.removeAlmostEqualCharacters("zyxyxyz"));
    }

}
