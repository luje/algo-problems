package org.home.interview;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MultipleRequestsAtATime {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename = scan.nextLine();

        Set<String> result = new HashSet<>();
        Set<String> seen = new HashSet<>();

        try (FileInputStream fis = new FileInputStream(filename);
             Scanner fscanner = new Scanner(fis)) {
            while (fscanner.hasNext()) {
                String date = parse(fscanner.nextLine());

                if(seen.contains(date)) {
                    result.add(date);
                } else {
                    seen.add(date);
                }
            }
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("req_" + filename))) {
            for (String s : seen) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        }
    }

    static String parse(String line) {
        final var timestampStr = line.substring(
                line.indexOf("["),
                line.indexOf("]")
        );

        return timestampStr.substring(0, timestampStr.indexOf(" "));
    }

}
