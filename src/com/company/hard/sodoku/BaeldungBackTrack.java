package com.company.hard.sodoku;

public class BaeldungBackTrack {
    //https://www.baeldung.com/java-sudoku
    
    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START_INDEX = 0;

    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

//    private static int[][] board = {
//            {8, 0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 3, 6, 0, 0, 0, 0, 0},
//            {0, 7, 0, 0, 9, 0, 2, 0, 0},
//            {0, 5, 0, 0, 0, 7, 0, 0, 0},
//            {0, 0, 0, 0, 4, 5, 7, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 3, 0},
//            {0, 0, 1, 0, 0, 0, 0, 6, 8},
//            {0, 0, 8, 5, 0, 0, 0, 1, 0},
//            {0, 9, 0, 0, 0, 0, 4, 0, 0}
//    };

    public static void main(String[] args) {
        int[][] board = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        BaeldungBackTrack solver = new BaeldungBackTrack();
        solver.solve(board);
        solver.printBoard(board);
    }

    private void solve(int[][] board) {

    }

    private void printBoard(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }
}
