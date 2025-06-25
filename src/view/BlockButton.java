package view;

import javax.swing.*;
import java.awt.*;

public class BlockButton extends JButton {
    final String name;
    public BlockButton(String newName, Dimension SizeDimension) {
        name = newName;
        this.initButton(SizeDimension);
    }

    public void initButton(Dimension dim) {
        this.setSize(dim);
        this.setVisible(true);
    }

}
