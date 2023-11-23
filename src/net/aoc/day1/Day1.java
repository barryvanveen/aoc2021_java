package net.aoc.day1;

import net.aoc.input.Input;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();

        try {
            input = Input.ConvertStringToInt(
                Input.ReadLinesFromFile("day1.txt")
            );
        } catch (Exception ex) {
            System.out.println(String.format("Error reading input: %s", ex.toString()));
        }

        part1(input);
        part2(input);
    }

    public static void part1(List<Integer> input)
    {
        int i, counter = 0;
        int prev = input.get(0);

        for (i = 1; i < input.size(); i++) {
            int current = input.get(i);
            if (current > prev) counter++;
            prev = current;
        }

        System.out.println("Part 1: " + counter);
    }

    public static void part2(List<Integer> input)
    {
        int i, counter = 0;
        int prev = input.get(0) + input.get(1) + input.get(2);

        for (i = 3; i < input.size(); i++) {
            int current = input.get(i) + input.get(i-1) + input.get(i-2);
            if (current > prev) counter++;
            prev = current;
        }

        System.out.println("Part 2: " + counter);
    }
}
