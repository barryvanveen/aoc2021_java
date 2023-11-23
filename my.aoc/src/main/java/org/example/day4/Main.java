package org.example.day4;

import org.example.input.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Board> boards = new ArrayList<>();
        Draws draws;

        try {
            List<String> input = Input.ReadLinesFromFile("day4.txt");

            draws = new Draws(input.get(0));

            String boardInput = "";
            for (int i = 2; i<input.size(); i++) {
                String line = input.get(i);

                // if we reached a blank line, move to next board
                if (line.isBlank() && !boardInput.isEmpty()) {
                    boards.add(new Board(boardInput, draws));
                    boardInput = "";
                    continue;
                }

                boardInput = boardInput + " " + line;
            }

            boards.add(new Board(boardInput, draws));
        } catch (Exception ex) {
            System.out.printf("Error reading input: %s%n", ex);
            throw ex;
        }

        part1(boards);
        part2(boards);
    }

    public static void part1(List<Board> boards)
    {
        List<Integer> i = boards.stream().map(Board::completeAt).toList();

        int winningDraw = Collections.min(i);
        int winningBoard = i.indexOf(winningDraw);

        int answer = boards.get(winningBoard).score(winningDraw);

        System.out.println("Part 1: " + answer);
    }

    public static void part2(List<Board> boards)
    {
        List<Integer> i = boards.stream().map(Board::completeAt).toList();

        int winningDraw = Collections.max(i);
        int winningBoard = i.indexOf(winningDraw);

        int answer = boards.get(winningBoard).score(winningDraw);

        System.out.println("Part 2: " + answer);
    }
}
