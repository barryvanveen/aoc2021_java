package org.example.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day4Test {

    @Test
    void ComputesCompleteAt() {
        String inputDraws = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        String inputBoard = "14 21 17 24  4 10 16 15  9 19 18  8 23 26 20 22 11 13  6  5 2  0 12  3  7";
        Draws draws = new Draws(inputDraws);
        Board board = new Board(inputBoard, draws);

        assertEquals(11, board.completeAt());
    }

    @Test
    void ComputesCompleteAtWithWinningColumn() {
        String inputDraws = "7,4,9,5,11,17,23,2,0,14,26,20,19,10,16,13,6,15,25,12,22,18,8,3,1,21,24";
        String inputBoard = "14 21 17 24 4 10 16 15 9 19 18 8 23 26 20 22 11 13 6 5 2 0 12 3 7";
        Draws draws = new Draws(inputDraws);
        Board board = new Board(inputBoard, draws);

        assertEquals(12, board.completeAt());
    }

    @Test
    void ComputesCompleteAtDifferentNumbers() {
        String inputDraws = "14,8,18,10,22,34,46,4,0,28,42,48,20,32,26,12,30,50,24,44,36,40,16,38,6,52,2";
        String inputBoard = "28 42 34 48 8 20 32 30 18 38 36 16 46 52 40 44 22 26 12 10 4 0 24 6 14";
        Draws draws = new Draws(inputDraws);
        Board board = new Board(inputBoard, draws);

        assertEquals(11, board.completeAt());
    }

    @Test
    void ComputesScore() {
        String inputDraws = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        String inputBoard = "14 21 17 24 4 10 16 15 9 19 18 8 23 26 20 22 11 13 6 5 2 0 12 3 7";
        Draws draws = new Draws(inputDraws);
        Board board = new Board(inputBoard, draws);

        int expectedScore = (10 + 16 + 15 + 19 + 18 + 8 + 26 + 20 + 22 + 13 + 6 + 12 + 3) * 24;

        assertEquals(expectedScore, board.score(board.completeAt()));
    }

    @Test
    void ComputesScoreWithWinningColumn() {
        String inputDraws = "7,4,9,5,11,17,23,2,0,14,26,20,19,10,16,13,6,15,25,12,22,18,8,3,1,21,24";
        String inputBoard = "14 21 17 24 4 10 16 15 9 19 18 8 23 26 20 22 11 13 6 5 2 0 12 3 7";
        Draws draws = new Draws(inputDraws);
        Board board = new Board(inputBoard, draws);

        int expectedScore = (21 + 24 + 10 + 16 + 15 + 18 + 8 + 22 + 13 + 6 + 12 + 3) * 19;

        assertEquals(expectedScore, board.score(board.completeAt()));
    }

    @Test
    void ComputesScoreDifferentNumbers() {
        String inputDraws = "14,8,18,10,22,34,46,4,0,28,42,48,20,32,26,12,30,50,24,44,36,40,16,38,6,52,2";
        String inputBoard = "28 42 34 48 8 20 32 30 18 38 36 16 46 52 40 44 22 26 12 10 4 0 24 6 14";
        Draws draws = new Draws(inputDraws);
        Board board = new Board(inputBoard, draws);

        int expectedScore = (20 + 32 + 30 + 38 + 36 + 16 + 52 + 40 + 44 + 26 + 12 + 24 + 6) * 48;

        assertEquals(expectedScore, board.score(board.completeAt()));
    }
}
