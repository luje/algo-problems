package other;

public class LongestSubstringWithoutRepeatingChars {
    final boolean[] seen = new boolean[128];
    String input;

    public int lengthOfLongestSubstring(String s) {
        input = s;

        int max = Math.min(s.length(), 1);
        int j = 0;

        for(int i = 0; i < s.length() && max < s.length() - i; i++) {
            set(i);

            for(j = Math.max(i + 1, j); j < s.length() && !seen(j); j++) {
                set(j);
            }

            max = Math.max(max, j - i);

            reset(i);
        }

        return max;
    }

    private Boolean set(int i) {
        return seen[input.charAt(i)] = true;
    }

    private Boolean reset(int i) {
        return seen[input.charAt(i)] = false;
    }

    private Boolean seen(int i) {
        return seen[input.charAt(i)];
    }

    public static void main(String[] args) {
        final LongestSubstringWithoutRepeatingChars solver = new LongestSubstringWithoutRepeatingChars();

        System.out.println(solver.lengthOfLongestSubstring("au"));
        System.out.println(solver.lengthOfLongestSubstring(" "));
        System.out.println(solver.lengthOfLongestSubstring(""));
        System.out.println(solver.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solver.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solver.lengthOfLongestSubstring("pwwkew"));
    }
}
