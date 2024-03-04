package org.home.advent2022;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;

public class P5 {

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        List<String> stackDef = new ArrayList<>();
        List<Stack<Character>> stacks = null;

        while (input.hasNext()) {
            final String line = input.nextLine();

            if (line.isEmpty()) {
                stacks = createStacks(stackDef);
            } else if (stacks != null) {
                stacks = move9001(stacks, line);
            } else {
                stackDef.add(line);
            }
        }

        System.out.println(stacks.stream()
                .map(Stack::peek)
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }

    private static List<Stack<Character>> move9000(List<Stack<Character>> stacks, String line) {
        final List<Integer> instruction = Arrays.stream(line.replace("move", "")
                        .replace("from", "")
                        .replace("to", "")
                        .split(" "))
                .filter(it -> !it.isEmpty())
                .map(s -> valueOf(s))
                .collect(Collectors.toList());

        final Integer fromIndex = instruction.get(1) - 1;
        final Integer toIndex = instruction.get(2) - 1;

        final Stack<Character> target = stacks.get(toIndex);
        final Stack<Character> source = stacks.get(fromIndex);

        for (int i = 0; i < instruction.get(0); i++) {
            target.push(source.pop());
        }

        return stacks;
    }

    private static List<Stack<Character>> move9001(List<Stack<Character>> stacks, String line) {
        final List<Integer> instruction = Arrays.stream(line.replace("move", "")
                        .replace("from", "")
                        .replace("to", "")
                        .split(" "))
                .filter(it -> !it.isEmpty())
                .map(s -> valueOf(s))
                .collect(Collectors.toList());

        final Integer fromIndex = instruction.get(1) - 1;
        final Integer toIndex = instruction.get(2) - 1;
        final Stack<Character> source = stacks.get(fromIndex);
        final Stack<Character> target = stacks.get(toIndex);

        final Stack<Character> aux = new Stack<>();

        for (int i = 0; i < instruction.get(0); i++) {
            aux.add(source.pop());
        }

        while (!aux.isEmpty()) {
            target.push(aux.pop());
        }

        System.out.println(stacks);

        return stacks;
    }

    private static List<Stack<Character>> createStacks(List<String> stackDef) {
        final List<Stack<Character>> result = new ArrayList<>();

        final String count = stackDef.get(stackDef.size() - 1);

        for (int i = 0; i < count.length(); i += 4) {
            result.add(new Stack<>());
        }

        for (int i = stackDef.size() - 2; i >= 0; i--) {
            final String line = stackDef.get(i);

            for (int j = 0; j <= line.length() / 4; j++) {
                final String content = line.substring(j * 4, Math.min((j + 1) * 4, line.length() - 1)).trim();

                if (!content.isEmpty()) {
                    result.get(j).push(content.charAt(1));
                }
            }
        }

        return result;
    }
}
