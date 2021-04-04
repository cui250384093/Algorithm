package com.yl.knight;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author candk
 * @Description
 * @date 4/4/21 - 2:10 PM
 */
public class ChessBoard {

    private static int size;
    private static int[][] board;
    private static boolean[][] visited;
    private int stepNum;
    private static boolean finished;

    public ChessBoard() {
    }

    public ChessBoard(int size) {
        board = new int[size][size];
        visited = new boolean[size][size];
    }

    public void showBoard() {
        for (int[] steps : board) {
            System.out.println(Arrays.toString(steps));
        }
    }

    public static ArrayList<Point> nextPoints(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<>();

        if (curPoint.x - 2 >= 0 && curPoint.y - 1 >= 0) {
            ps.add(new Point(curPoint.x - 2, curPoint.y - 1));
        }

        if (curPoint.x - 1 >= 0 && curPoint.y - 2 >= 0) {
            ps.add(new Point(curPoint.x - 1, curPoint.y - 2));
        }

        if (curPoint.x + 2 < size && curPoint.y - 1 >= 0) {
            ps.add(new Point(curPoint.x + 2, curPoint.y - 1));
        }

        if (curPoint.x + 1 < size && curPoint.y - 2 >= 0) {
            ps.add(new Point(curPoint.x + 1, curPoint.y - 2));
        }

        if (curPoint.x + 2 < size && curPoint.y + 1 < size) {
            ps.add(new Point(curPoint.x + 2, curPoint.y + 1));
        }

        if (curPoint.x + 1 < size && curPoint.y + 2 < size) {
            ps.add(new Point(curPoint.x + 1, curPoint.y + 2));
        }

        if (curPoint.x - 2 >= 0 && curPoint.y + 1 < size) {
            ps.add(new Point(curPoint.x - 2, curPoint.y + 1));
        }

        if (curPoint.x - 1 >= 0 && curPoint.y + 2 < size) {
            ps.add(new Point(curPoint.x - 1, curPoint.y + 2));
        }

        return ps;
    }

    /**
     * 骑士周游算法
     * @param row 马儿当前位置 行
     * @param column 马儿当前位置 列
     * @param stepNum 第几步
     */
    public static void traversalChessBoard(int row, int column, int stepNum) {
        board[row][column] = stepNum;
        visited[row][column] = true;
        ArrayList<Point> ps = nextPoints(new Point(column, row));

        while (!ps.isEmpty()) {
            Point point = ps.remove(0);
            if (!visited[point.y][point.x]) {
                traversalChessBoard(point.y, point.x, stepNum + 1);
            }
        }

        if (stepNum < size * size && !finished) {
            board[row][column] = 0;
            visited[row][column] = false;
        } else {
            finished = true;
        }
    }

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard(4);
        ChessBoard.traversalChessBoard(1,1,0);
        board.showBoard();
    }
}
