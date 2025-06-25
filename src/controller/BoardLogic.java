package controller;

import model.Board;

public class BoardLogic implements BoardLogicInterface {
    private Board board;

    public BoardLogic(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

    public int getColumnAndRowSize() {
        return isBoardQuadratic() ? (int) Math.sqrt(this.board.getGridSize()) : 0;
    }

    public boolean isBoardQuadratic() {
        int size = this.board.getGridSize();
        int side = (int) Math.sqrt(size);
        return side * side == size;
    }

}
