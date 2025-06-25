package view;

import javax.swing.*;
import java.awt.*;

public class BlockButton extends JButton {
    final String name;
    public BlockButton(String newName, Dimension SizeDimension) {
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
           System.out.println(name);
        });
    }

}
