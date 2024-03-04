package org.home.other4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/description/
public class FavouriteCompanies {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        final Map<String, List<Integer>> index = new HashMap<>();

        for (int person = 0; person < favoriteCompanies.size(); person++) {
            final var fav = favoriteCompanies.get(person);

            for (String company : fav) {
                index.computeIfAbsent(company, key -> new ArrayList<>()).add(person);
            }
        }

        final var result = new ArrayList<Integer>();

        for (int person = 0; person < favoriteCompanies.size(); person++) {
            if(isUnique(favoriteCompanies.get(person), index)) {
                result.add(person);
            }
        }

        return result;
    }

    public boolean isUnique(List<String> fav, Map<String, List<Integer>> index) {
        var intersection = index.get(fav.get(0));

        for (int i = 1; i < fav.size(); i++) {
            var other = index.get(fav.get(i));

            var result = new ArrayList<Integer>();

            int p = 0;
            int q = 0;

            while(p < intersection.size() && q < other.size()) {
                if(intersection.get(p) == other.get(q)) {
                    result.add(intersection.get(p));

                    p++;
                    q++;
                } else if(intersection.get(p) > other.get(q)) {
                    q++;
                } else {
                    p++;
                }
            }

            intersection = result;
        }

        return intersection.size() == 1;
    }

    public static void main(String[] args) {
        final var solver = new FavouriteCompanies();

        System.out.println(solver.peopleIndexes(
                List.of(
                        List.of("leetcode", "google", "facebook"),
                        List.of("google", "microsoft"),
                        List.of("google", "facebook"),
                        List.of("google"),
                        List.of("amazon")
                )
        ));

        System.out.println(solver.peopleIndexes(List.of(
                List.of("leetcode", "google", "facebook"),
                List.of("leetcode", "amazon"),
                List.of("facebook", "google")
        )));
    }
}

