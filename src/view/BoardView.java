package view;

import controller.BoardLogic;
import model.Block;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

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

        controller.addPropertyChangeListener(e -> updateView());

        GridDimension = boardController.getColumnAndRowDimension();
        SizeDimension = new Dimension(boardController.getBoard().getBoardWidth(),
                boardController.getBoard().getBoardHeight());
        this.initView();
        this.startGame();
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
     * rebuilds the Blocks as Button to be ready presented in View
     */
    public void rebuildView() {
        createButtons(boardController.getBoard().getBlocks());
    }


    /**
     * Starts the Game
     */
    public void startGame(){
        createButtons(boardController.startGame());
    }


    /** Blocks that
     * @param blocks the List Block which needs to be created
     */
    public void createButtons(List<Block> blocks) {
        for (Block btnBlock : blocks) {
            JButton btn = new BlockButton(btnBlock.getName(),
                    new Dimension(btnBlock.getSizeWidth(), btnBlock.getSizeHeight()),
                    this.boardController);
            if (!Objects.isNull(btnBlock.getName()) && blocks.indexOf(btnBlock) == btnBlock.getCorrectPosition())
                btn.setBackground(btnBlock.CORRECT_POSITION(true));
            else btn.setBackground(btnBlock.CORRECT_POSITION(false));
            this.add(btn);
        }
    }

    public void playerHasWon() {
        if (!boardController.playerHasWon()) return;
        JFrame winFrame = new JFrame("Congratz !");
        winFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        winFrame.setSize(300, 150);
        winFrame.setLocationRelativeTo(null);

        winFrame.add(new JLabel("YOU WON !!!", SwingConstants.CENTER));
        winFrame.setVisible(true);

        Toolkit.getDefaultToolkit().beep();
    }

    public void updateView() {
        this.playerHasWon();
        this.getContentPane().removeAll();
        this.rebuildView();
        this.revalidate();
    }

}
