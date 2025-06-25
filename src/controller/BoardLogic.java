package controller;

import model.Block;
import model.Board;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;


/**
 * The Overall Logic for the Puzzle Game
 */

public class BoardLogic implements BoardLogicInterface {
    private Board board;

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

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

    public List<Block> startGame() {
        List<Block> sortedList = this.board.getBlocks();
        do Collections.shuffle(sortedList);
        while (!isSolveable() && this.getColumnAndRowDimension() % 2 == 1);

        do Collections.shuffle(sortedList);
        while (isSolveable() && this.getColumnAndRowDimension() % 2 == 0);
        return sortedList;
    }

    public boolean isSolveable() {
        List<Block> blocks = this.board.getBlocks();
        int inversions = 0;
        int emptyRow = 0; // Row of empty space (0-based from top)

        // Count inversions and find empty space row
        for (int i = 0; i < blocks.size(); i++) {
            Block current = blocks.get(i);

            // Skip empty block but record its row
            if (current.getName() == null || current.getName().isEmpty()) {
                emptyRow = i / (int)Math.sqrt(blocks.size());
                continue;
            }

            for (int j = i + 1; j < blocks.size(); j++) {
                Block next = blocks.get(j);

                // Skip empty block in comparison
                if (next.getName() == null || next.getName().isEmpty()) {
                    continue;
                }

                // Count inversion
                if (current.getCorrectPosition() > next.getCorrectPosition()) {
                    inversions++;
                }
            }
        }

        int gridSize = (int)Math.sqrt(blocks.size());

        // For odd grid sizes (3x3), inversions must be even
        if (gridSize % 2 == 1) {
            return inversions % 2 == 0;
        }
        // For even grid sizes (2x2, 4x4), sum of inversions and empty row must be odd
        else {
            return (inversions + (gridSize - 1 - emptyRow)) % 2 == 1;
        }
    }

    public boolean playerHasWon() {
        for (Block block : this.board.getBlocks()) {
            if (!Objects.isNull(block.getName()) && this.board.getBlocks().indexOf(block) != block.getCorrectPosition())
                return false;
        }
        return true;
    }

    public boolean moveBlock(String clickedBlock) {
        int emptyPos = board.getEmptyBlockPosition();
        int clickedBlockPosition = board.getBlockPosition(clickedBlock);
        if (emptyPos != -1 && clickedBlockPosition != -1) {
            if(isMoveable(clickedBlockPosition, emptyPos)) {
                Collections.swap(board.getBlocks(), clickedBlockPosition, emptyPos);
                support.firePropertyChange("boardState", null, board.getBlocks());
                return true;
            };
        }
        return false;
    }



    public boolean isMoveable(int blockA, int blockB) {
        int rowA = blockA / this.getColumnAndRowDimension();
        int colA = blockA % this.getColumnAndRowDimension();
        int rowB = blockB / this.getColumnAndRowDimension();
        int colB = blockB % this.getColumnAndRowDimension();
        return Math.abs(rowA - rowB) + Math.abs(colA - colB) == 1;
    }


}
