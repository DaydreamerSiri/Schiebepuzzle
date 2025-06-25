package view;

import controller.BoardLogic;

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
    public BoardView(BoardLogic controller){
        boardController = controller;
        GridDimension = boardController.getColumnAndRowDimension();
        this.initView();
        this.createBlocksInView();
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
        this.setPreferredSize(new Dimension(boardController.getBoard().getBoardWidth(), boardController.getBoard().getBoardHeight()));
    }


    /**
     * Creates the Blocks as Button to be ready presented in View
     *
     * @return List with all Blocks as Button
     */
    public List createBlocksInView(){
        List res = boardController.getBoard().initializeBlocks(boardController.getBoard().getBlockCount());
        for (int i = 0; i < res.size(); i++) {
            this.add(new Button("Test"));
        }
        return res;
    }


}
