package view;

import controller.BlockLogic;

import javax.swing.*;

public class BoardView extends JPanel {
    private JPanel boardPnl;
    private BlockLogic boardController;

    public BoardView(BlockLogic controller){
        boardController = controller;
    }

    public JPanel initView() {
        boardController.getBoard().getBlockCount();
        return null;
    }

}
