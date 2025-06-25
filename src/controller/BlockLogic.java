package controller;

import model.Board;

public class BlockLogic {
    private Board board;

    public BlockLogic(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

}
