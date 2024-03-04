package neetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(it -> sort(it)))
                .values());
    }

    private static String sort(String it) {
        return it.chars().sorted().mapToObj(e -> Character.toString((char) e)).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(sort("bca"));
    }
}
