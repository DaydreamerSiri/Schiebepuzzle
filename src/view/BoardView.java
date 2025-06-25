package view;

import controller.BoardLogic;
import model.Block;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * BoardView for Puzzle Game
 * holds the overall Board and it's Blocks as a JFrame
 * @author Sehri Singh
 * @version prototype
 */
public class BoardView extends JFrame {
    private JPanel boardPnl;
    private BoardLogic boardController;
    final private Integer GridDimension;
    final private Dimension SizeDimension;

    public BoardView(BoardLogic controller){
        boardController = controller;
        GridDimension = boardController.getColumnAndRowDimension();
        SizeDimension = new Dimension(boardController.getBoard().getBoardWidth(),
                boardController.getBoard().getBoardHeight());
        this.initView();
        this.createBlocksInView();
        boardController.startGame();
        this.pack();
        this.setVisible(true);
    }


    /**
     *  Initializes the Frames View and it's Objects inside the Frame
     */
    public void initView() {
        GridLayout layout = new GridLayout();
        layout.setColumns(GridDimension);
        layout.setRows(GridDimension);
        this.setLayout(layout);
        this.setTitle("Puzzlespiel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(SizeDimension);
    }

    /**
     * Creates the Blocks as Button to be ready presented in View
     *
     * @return List with all Blocks as Button
     */
    public java.util.List<Block> createBlocksInView(){
        List<Block> res = boardController.getBoard().initializeBlocks(boardController.getBoard().getBlockCount());
        for (Block btnBlock : res) {
            this.add(new BlockButton(btnBlock.getName(), new Dimension(btnBlock.getSizeWidth(), btnBlock.getSizeHeight())));
        }
        return res;
    }


}
