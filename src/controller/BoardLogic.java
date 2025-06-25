package controller;

import model.Block;
import model.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * The Overall Logic for the Puzzle Game
 */

public class BoardLogic implements BoardLogicInterface {
    private Board board;

    /** Constructor Function
     * @param board needs the created Board Model to be used for the Logics
     */
    public BoardLogic(Board board) {
        this.board = board;
    }


    /** Getter Function for Board
     * @return the Board
     */
    public Board getBoard() {
        return this.board;
    }

    /** calculates and gets the Quadratic Dimension for Column and Row Size of Boards GridSize
     * @return the Column and Row Dimension
     */
    public int getColumnAndRowDimension() {
        return isBoardQuadratic() ? (int) Math.sqrt(this.board.getGridSize()) : 0;
    }


    /** Check function if the Board has a Quadratic Size (e.g 3x3, 2x2 ... N x N)
     * @return True if the board is Quadratic or False if not
     */
    public boolean isBoardQuadratic() {
        int size = this.board.getGridSize();
        int side = (int) Math.sqrt(size);
        return side * side == size;
    }

    public List startGame() {
        Random random = new Random();

        List sortedList = this.board.getBlocks();
        for (int i = 0; i < this.board.getGridSize(); i++) {
            int randomNum = random.nextInt(this.board.getGridSize());
            Collections.swap(sortedList, i, randomNum);
        }

        return sortedList;
    }




}
