import controller.BoardLogic;
import model.Board;
import view.BoardView;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BoardView gui = new BoardView(new BoardLogic(new Board()));
            }
        });
    }
}