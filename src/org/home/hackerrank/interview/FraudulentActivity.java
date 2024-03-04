package org.home.hackerrank.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FraudulentActivity {
    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here

        final var n = expenditure.size();
        final var running = new ArrayList<Integer>(d);

        Collections.fill(running, 201);

        int alerts = 0;
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (c == d && median2(running) <= expenditure.get(i)) {
                alerts++;
            }

            if (c == d) {
                remove(running, expenditure.get(i - c));
                c--;
            }

            insert(running, expenditure.get(i));
            c++;
        }

        return alerts;
    }

    private static void insert(List<Integer> running, Integer v) {
        final var i = Collections.binarySearch(running, v);

        running.add(i < 0 ? -i - 1 : i, v);
    }

    private static void remove(List<Integer> running, Integer v) {
        final var i = Collections.binarySearch(running, v);

        running.remove(i);
    }

    private static int median2(List<Integer> running) {
        final var n = running.size();

        return n % 2 != 0 ?
                running.get(n / 2) * 2 :
                running.get((n - 1) / 2) + running.get((n - 1) / 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(FraudulentActivity.activityNotifications(List.of(1, 2, 3, 4, 6), 4));
        System.out.println(FraudulentActivity.activityNotifications(List.of(2, 3, 4, 2, 3, 6, 8, 4, 5), 5));
        System.out.println(FraudulentActivity.activityNotifications(List.of(1, 2, 3, 4, 4), 4));


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = activityNotifications(expenditure, d);

        System.out.println("633 = " + result);

        bufferedReader.close();
    }
}
