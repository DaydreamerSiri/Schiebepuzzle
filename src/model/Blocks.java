package model;

import model.interfacemodel.BlockInterface;

import java.util.List;

public class Blocks implements BlockInterface {
    final List<Blocks> PLAYBLOCKS = List.of(null);

    @Override
    public List<Blocks> initalizeBlocks() {
        return List.of();
    }

    @Override
    public Integer getBlockCount() {
        return 0;
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
