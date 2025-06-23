package model;

import model.interfacemodel.BlockInterface;
import model.interfacemodel.BoardInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Board<V> implements BoardInterface {
    private final List<Block> blocks ;

    public Board() {
        blocks = initializeBlocks(TOTAL_BLOCKS);
    }

    @Override
    public List<Block> initializeBlocks(int remain) {
        if(remain == 0) return new ArrayList<>();
        List<Block> blocks = initializeBlocks(--remain);
        blocks.add(0, new Block(remain, String.valueOf(remain)));
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
}

