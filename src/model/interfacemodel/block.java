package model.interfacemodel;

import model.Blocks;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public interface block {

    /**
     *  CONSTANT ENUM FOR POSITIONAL COLORS
     * */
    enum PositionalColors {
        CORRECT(Color.GREEN), WRONG(Color.RED);
        private final Color color;
        PositionalColors(Color color) {
            this.color = Objects.requireNonNull(color);
        }

        public Color getColor(){
            return color;
        }

    }

    int BLOCKAMOUNT = 9 - 1; // 3 x 3 grid with 1 Space Free
    boolean correctPosition = false;
    boolean moveable = false;



    List<Blocks> initBlocks();

    Integer getBlockAmount();

    boolean isCorrectPosition();

    boolean isMoveable();


}
