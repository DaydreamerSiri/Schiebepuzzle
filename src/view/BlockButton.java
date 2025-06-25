package view;

import controller.BoardLogic;

import javax.swing.*;
import java.awt.*;

public class BlockButton extends JButton {
    final String name;
    final private BoardLogic boardController;

    public BlockButton(String newName, Dimension SizeDimension, BoardLogic controller) {
        boardController = controller;
        name = newName;
        this.setText(name);
        this.initButton(SizeDimension);
        this.setActionEvent();
    }

    public void initButton(Dimension dim) {
        this.setSize(dim);
        if (this.getText() != null) {
            this.setVisible(true);
        } else {
            this.setVisible(false);
        }
    }

    public void setActionEvent() {
        this.addActionListener( e -> {
            if(boardController.moveBlock(this.name)) {
                this.repaint();
                System.out.println(name+"\s has been moved");
            }
        });
    }

}
