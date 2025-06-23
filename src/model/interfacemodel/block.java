package model.interfacemodel;

import model.Blocks;

import java.awt.*;
import java.util.List;

public interface block {

    /**
     *  CONSTANT ENUM FOR POSITIONAL COLORS
     * */
    enum PositionalColors {
        CORRECT(Color.GREEN), WRONG(Color.RED);
        private final Color color;
        PositionalColors(Color color) {
            this.color = color;
        }

        public Color getColor(){
            return color;
        }

    }

    static final int BLOCKAMOUNT = 9 - 1;
    static final boolean correctPosition = false;
    static final boolean moveable = false;



    public abstract List<Blocks> initBlocks();

    public abstract Integer getBlockAmount();

    public abstract boolean isOnCorrectPosition();

    public abstract boolean isMoveAble();


}
