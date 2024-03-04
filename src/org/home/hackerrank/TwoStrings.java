package org.home.hackerrank;

import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

    public static String twoStrings(String s1, String s2) {
        final Set<Character> chars1 = s1.chars().mapToObj(it -> (char) it).collect(Collectors.toSet());
        final Set<Character> chars2 = s2.chars().mapToObj(it -> (char) it).collect(Collectors.toSet());

        return chars1.stream().anyMatch(c -> chars2.contains(c)) ? "YES" : "NO";
    }

}
