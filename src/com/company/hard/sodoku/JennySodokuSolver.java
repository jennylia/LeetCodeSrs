package com.company.hard.sodoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JennySodokuSolver {
    private static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.printf(" " + board[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0, 0, 0, 0, 2, 0, 0},
                {4, 0, 9, 8, 7, 1, 0, 0, 3},
                {0, 0, 3, 0, 0, 0, 4, 0, 0},
                {0, 4, 5, 3, 0, 7, 0, 0, 0},
                {0, 8, 0, 0, 4, 0, 0, 9, 0},
                {0, 0, 0, 2, 0, 5, 3, 8, 0},
                {0, 0, 4, 7, 5, 0, 9, 0, 0},
                {5, 0, 0, 6, 2, 3, 8, 0, 7},
                {0, 0, 7, 0, 0, 0, 0, 5, 0},
        };

        solve(board);
    }


    private static void solve(int[][] board) {
        // Create cells and candidates

        Cell[][] cells = boardToCell(board);
        Board b = new Board(cells);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                Cell c = b.getCell(i, j);

                if (c.val == 0) {
                    Set<Integer> candidates = findCandidates(b, c, i, j);
                    c.candidates = candidates;
                }
            }
        }
        System.out.println("first candidate run through");
        b.printBoard();


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Cell c = b.getCell(i, j);
                if (c.val == 0 && c.candidates.size() == 1) {
                    System.out.println("only 1 candidate " + i + " " + j);
                    c.val = c.candidates.iterator().next();

                    c.candidates.remove(c.val);

                    //remove all the other candidates for the row
                    System.out.println(c.val);
                    System.out.println(c.candidates);
                    removeOtherCandidates(b, c, i, j);
                }

            }
        }

        System.out.println("second candidate run through");
        b.printBoard();


    }

    private static void removeOtherCandidates(Board board, Cell cell, int row, int column) {
        // eliminate all row candidates
        for (int i = 0; i < 9; i ++){
            Cell c = board.getCell(row, i);
            if (c.val == 0){
                c.candidates.remove(cell.val);
            }
        }

        for (int i = 0; i < 9; i ++){
            Cell c = board.getCell(i, column);
            if (c.val == 0){
                c.candidates.remove(cell.val);
            }
        }

        int sqRow = row / 3;
        int sqCol = column / 3;
        int sqRowStart = sqRow * 3;
        int sqColStart = sqCol * 3;
        for (int i = sqRowStart; i < sqRowStart + 3; i++) {
            for (int j = sqColStart; j < sqColStart + 3; j++) {
                Cell c = board.getCell(i, j);
                if (board.getCell(i, j).val == 0) {
                    c.candidates.remove(cell.val);
                }
            }
        }
    }

    private static Set<Integer> findCandidates(Board board, Cell c, int row, int col) {
        Set<Integer> candidates = new HashSet<>();

        for (int v = 1; v < 10; v++) {
            boolean rowOk = true;
            boolean colOk = true;
            boolean sqOk = true;
            if (v == c.val) {
                continue;
            }
            for (int j = 0; j < 9; j++) {
                if (board.getCell(row, j).val == v) {
                    rowOk = false;
                    break;
                }
            }

            for (int j = 0; j < 9; j++) {
                if (board.getCell(j, col).val == v) {
                    colOk = false;
                    break;
                }
            }

            int sqRow = row / 3;
            int sqCol = col / 3;
            int sqRowStart = sqRow * 3;
            int sqColStart = sqCol * 3;
            for (int i = sqRowStart; i < sqRowStart + 3; i++) {
                for (int j = sqColStart; j < sqColStart + 3; j++) {
                    if (board.getCell(i, j).val == v) {

                        sqOk = false;
                        break;
                    }
                }
            }

            if (rowOk && colOk && sqOk) {
                candidates.add(v);
            }

        }
        return candidates;
    }


    private static Cell[][] boardToCell(int[][] board) {
        Cell[][] cells = new Cell[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new Cell(board[i][j], new HashSet<>());
            }
        }
        return cells;
    }

    private static class Board {
        Cell[][] cells;

        public Board(Cell[][] cells) {
            this.cells = cells;
        }

        private Cell getCell(int i, int j) {
            return cells[i][j];
        }

        private void printBoard() {
            for (int i = 0; i < 9; i++) {
                System.out.println();
                for (int j = 0; j < 9; j++) {
                    System.out.printf(" " + cells[i][j].val);
                }
            }

            for (int i = 0; i < 9; i++) {
                System.out.println();
                for (int j = 0; j < 9; j++) {

                    System.out.printf(" " + cells[i][j].candidates + "|");
                }
            }
        }
    }

    private static class Cell {
        int val;
        Set<Integer> candidates = new HashSet<>();

        public Cell(int val, Set<Integer> candidates) {
            this.val = val;
            this.candidates = candidates;
        }
    }
}
