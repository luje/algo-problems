package org.home.interview;

import java.util.HashMap;
import java.util.Map;

public class StringsDecoding {


    public static String decode(String encoded) {
        Map<String, Character> dict = new HashMap<>();

        for (char c = 'a'; c <= 'z'; c++) {
            dict.put(String.valueOf((int) c), c);
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf((int) c), c);
        }

        dict.put(String.valueOf((int) ' '), ' ');

        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = encoded.length() - 1; i >= 0 ; i--) {
            sb.append(encoded.charAt(i));

            if(dict.keySet().contains(sb.toString())) {
                result.append(dict.get(sb.toString()));
                sb = new StringBuilder();
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("23511011501782351112179911801562340161171141148"));
    }
}
