package model.interfacemodel;

import java.awt.*;
import java.util.Objects;


public interface BlockInterface {

    Integer SIZE_WIDTH = 50;
    Integer SIZE_HEIGHT = 50;


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

    Integer getSizeWidth();
    Integer getSizeHeight();

    boolean CORRECT_POSITION = false;
    boolean MOVEABLE = false;

    boolean isMoveable();


}
