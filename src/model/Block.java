package model;

import model.interfacemodel.BlockInterface;

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

    @Override
    public boolean isInCorrectPosition() {
        return false;
    }

    @Override
    public boolean isMoveable() {
        return false;
    }

    public String getName() {
        return name;
    }

    public Integer getCorrectPosition() {
        return correctPosition;
    }


}