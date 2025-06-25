package model;

import model.interfacemodel.BlockInterface;
import model.interfacemodel.BoardInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Board<V> implements BoardInterface {
    private final List<V> blocks ;

    public Board() {
        blocks = initializeBlocks(GRID_SIZE);
    }

    public Board(List<V> newGame) {
        blocks = newGame;
    }

    @Override
    public List<V> initializeBlocks(int remain) {
        if(remain == 0) return new ArrayList<>();

        List<V> blocks = initializeBlocks(--remain);
        if (remain == 8) blocks.add(blocks.size(), (V) new Block(remain, null));
        else blocks.add(blocks.size(), (V) new Block(remain, String.valueOf(remain)));

        return blocks;
    }

    @Override
    public Integer getBlockCount() {
        return TOTAL_BLOCKS;
    }

    @Override
    public Integer getGridSize() {
        return GRID_SIZE;
    }

    @Override
    public Integer getBoardWidth() {
        return WIDTH;
    }

    @Override
    public Integer getBoardHeight() {
        return HEIGHT;
    }

    public List<V> getBlocks() {
        return blocks;
    }

    @Override
    public void blocksInCorrectPosition() {

    }
}

