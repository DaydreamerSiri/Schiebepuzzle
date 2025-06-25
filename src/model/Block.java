package model;

import controller.BoardLogic;
import model.interfacemodel.BlockInterface;

import java.awt.*;
import java.util.List;

public class Block implements BlockInterface {

    final protected Integer correctPosition;

    final protected String name;

    public Block(Integer Value, String blockName){
        correctPosition = Value;
        name = blockName;
    }

    @Override
    public Integer getSizeWidth() {
        return SIZE_WIDTH;
    }

    @Override
    public Integer getSizeHeight() {
        return SIZE_HEIGHT;
    }

    public Color CORRECT_POSITION(boolean b) {
        return b ? PositionalColors.CORRECT.getColor() : PositionalColors.WRONG.getColor();
    }

    public String getName() {
        return name;
    }

    public Integer getCorrectPosition() {
        return correctPosition;
    }


}