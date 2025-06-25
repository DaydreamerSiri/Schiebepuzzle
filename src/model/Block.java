package model;

import model.interfacemodel.BlockInterface;

public class Block implements BlockInterface {
    final Integer correctPosition;
    final String name;

    public Block(Integer Value, String blockName){
        correctPosition = Value;
        name = blockName;
    }

    @Override
    public boolean isInCorrectPosition() {
        return false;
    }

    @Override
    public boolean isMoveable() {
        return false;
    }
}