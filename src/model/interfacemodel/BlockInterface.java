package model.interfacemodel;

import java.awt.*;
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

    boolean CORRECT_POSITION = false;
    boolean MOVEABLE = false;

    boolean isInCorrectPosition();

    boolean isMoveable();


}
