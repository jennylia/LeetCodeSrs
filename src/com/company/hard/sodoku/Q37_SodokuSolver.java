package com.company.hard.sodoku;

import java.util.ArrayList;
import java.util.List;

public class Q37_SodokuSolver {
    static int successCount = 0;

    public static class Board {
        char[][] board = new char[9][9];


        public Board(char[][] board) {
            this.board = board;
        }

        public void printBoard() {
            for (int i = 0; i < 9; i++) {
                System.out.println(board[i]);
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];

        board[0] = new char[]{'5', '3', '.', /**/ '.', '7', '.', /**/ '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', /**/ '1', '9', '5', /**/ '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', /**/ '.', '.', '.', /**/ '.', '6', '.'};

        board[3] = new char[]{'8', '.', '.', /**/ '.', '6', '.', /**/ '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', /**/ '8', '.', '3', /**/ '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', /**/ '.', '2', '.', /**/ '.', '.', '6'};

        board[6] = new char[]{'.', '6', '.', /**/ '.', '.', '.', /**/ '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', /**/ '4', '1', '9', /**/ '.', '.', '6'};
        board[8] = new char[]{'.', '.', '.', /**/ '.', '8', '.', /**/ '.', '7', '9'};
        Board b = new Board(board);
        b.printBoard();



        solveSodoku(board);
        System.out.println("success Count" + successCount);
    }

//    private static void printBoard(char[][] board) {
//        for (int i = 0; i < 9; i++) {
//            System.out.println(board[i]);
//        }
//    }


    private static void solveSodoku(char[][] board) {

        List<Board> candidates = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    //Candidates:
                    List<Board> candidatesNow = findCandidates(board, i, j);
                    candidates.addAll(candidatesNow);
                    System.out.println("candidate size " + candidates.size());



                }
            }
        }
    }

    private static List<Board> findCandidates(char[][] board, int i, int j) {

        List<Board> candidates = new ArrayList<>();

        for (int v = 1; v < 10; v++) {
            // check col of a row for this number
            for (int col = 0; col < 9; col++) {
                if (board[i][col] != Character.forDigit(v, 10)) {


                    // Check the rows of a column

                    for (int row = 0; row < 9; row++) {
                        if (board[row][j] != Character.forDigit(v, 10)) {

                            // now onto the square

                            int squareRow = i / 3;
                            int squareCol = j / 3;
                            int nr_start = squareRow * 3;
                            int nc_start = squareCol * 3;
                            int nr_end = nr_start + 2;
                            int nc_end = nc_start + 2;

                            for (int nr = nr_start * 3; nr < nr_end; nr++) {
                                for (int nc = nc_start * 3; nc < nc_end; nc++) {
                                    if (board[nr][nc] != Character.forDigit(v, 10)) {
                                        System.out.println("setting board value of " + v + " at i " + i + ", j " + j);
                                        board[i][j] = Character.forDigit(v, 10);

                                        Board b = new Board(board);
                                        candidates.add(b);

                                    }
                                }
                            }


                        }

                        // check the square

                    }
                }
            }


        }

        return null;
    }
}
