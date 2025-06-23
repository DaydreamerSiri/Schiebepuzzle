package model.interfacemodel;

import model.Blocks;
import java.awt.*;
import java.util.List;
import java.util.Objects;


public interface BlockInterface {

    /**
     *  Color indicators for block position states.
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

    int TOTAL_BLOCKS = 8 ; // 3 x 3 grid with 1 Space Free
    boolean CORRECT_POSITION = false;
    boolean MOVEABLE = false;



    List<Blocks> initalizeBlocks();

    Integer getBlockCount();

    boolean isInCorrectPosition();

    boolean isMoveable();


}
