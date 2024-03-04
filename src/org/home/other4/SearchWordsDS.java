package org.home.other4;

import java.util.*;

public class SearchWordsDS {

    // https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
    class WordDictionary {

        Map<Integer, List<String>> dict;

        public WordDictionary() {
            dict = new HashMap<>();
        }

        public void addWord(String word) {
            dict.computeIfAbsent(word.length(), key -> new ArrayList<>()).add(word);
        }

        public boolean search(String word) {
            return dict.getOrDefault(word.length(), Collections.emptyList())
                    .stream()
                    .anyMatch(other -> match(word, other));
        }

        private boolean match(String query, String other) {
            for (int i = 0; i < query.length(); i++) {
                char w = query.charAt(i);
                char o = other.charAt(i);

                if (w == o) continue;
                if (w == '.') continue;

                return false;
            }

            return true;
        }
    }

    class MagicDictionary {

        Map<Integer, List<String>> dict;

        public MagicDictionary() {
            dict = new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                dict.computeIfAbsent(word.length(), key -> new ArrayList<>()).add(word);
            }
        }

        public boolean search(String query) {
            return dict.getOrDefault(query.length(), Collections.emptyList())
                    .stream()
                    .anyMatch(other -> match(query, other));
        }

        private boolean match(String query, String other) {
            int diff = 0;

            for (int i = 0; i < query.length(); i++) {
                char w = query.charAt(i);
                char o = other.charAt(i);

                if (w == o) continue;
                if (w != o) diff++;

                if (diff > 1) return false;
            }

            return diff < 2;
        }
    }

    public static void main(String[] args) {
        final var wordDictionary = new SearchWordsDS().new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True


        System.out.println("===========");

        final var magicDictionary = new SearchWordsDS().new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello")); // return False
        System.out.println(magicDictionary.search("hhllo")); // We can change the second 'h' to 'e' to match "hello" so we return True
        System.out.println(magicDictionary.search("hell")); // return False
        System.out.println(magicDictionary.search("leetcoded")); // return False
    }
}
