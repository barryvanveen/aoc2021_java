package org.example.day4;

import java.util.Arrays;
import java.util.List;

public class Draws {

    List<Integer> numbers;

    public Draws(String input) {
        numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
    }

    public Integer draw(Integer number) {
        return numbers.indexOf(number);
    }
}
