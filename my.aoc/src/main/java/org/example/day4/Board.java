package org.example.day4;

import com.google.common.collect.Lists;
import org.example.input.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Board {
    private final Integer SIZE = 5;

    List<List<Integer>> numbers;
    List<List<Integer>> draws;

    public Board(String input, Draws inputDraws) {
        // trim, split, convert to ints
        List<Integer> numbersList = Input.ConvertStringToInt(
            Arrays.stream(input.trim().split("[\\s]+")).toList()
        );

        // map each number to its draw
        List<Integer> drawsList = numbersList.stream().map(
            inputDraws::draw
        ).toList();

        numbers = Lists.partition(numbersList, SIZE);
        draws = Lists.partition(drawsList, SIZE);
    }

    public Integer completeAt() {
        int minRow = bestRow(draws);
        int minCol = bestRow(transpose(draws));

        return Math.min(minRow, minCol);
    }

    public Integer score(Integer winningDraw) {
        List<Integer> flatNumbers = numbers.stream().flatMap(Collection::stream).toList();
        List<Integer> flatDraws = draws.stream().flatMap(Collection::stream).toList();
        int score = 0;

        for (int i = 0; i<flatNumbers.size(); i++) {
            // if this draw is after the winning draw
            if (flatDraws.get(i) > winningDraw) {
                score += flatNumbers.get(i);
            }
        }

        Integer winningNumber = flatNumbers.get(flatDraws.indexOf(winningDraw));

        return score * winningNumber;
    }

    public void print() {
        System.out.print("Board:\n");
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                System.out.printf("%2d ", numbers.get(i).get(j));
            }
            System.out.print('\n');
        }
        System.out.print('\n');

        System.out.print("Draws:\n");
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                System.out.printf("%2d ", draws.get(i).get(j));
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    private Integer bestRow(List<List<Integer>> i) {
        return i.stream()
            .map(v -> v.stream().reduce(Math::max).orElseThrow())
            .reduce(Math::min)
            .orElseThrow();
    }

    static <T> List<List<T>> transpose(List<List<T>> table) {
        List<List<T>> ret = new ArrayList<List<T>>();
        final int N = table.get(0).size();
        for (int i = 0; i < N; i++) {
            List<T> col = new ArrayList<T>();
            for (List<T> row : table) {
                col.add(row.get(i));
            }
            ret.add(col);
        }
        return ret;
    }
}
