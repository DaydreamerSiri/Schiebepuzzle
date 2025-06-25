package model;

import model.interfacemodel.BoardInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Board implements BoardInterface {
    private final List<Block> blocks ;

    public Board() {
        blocks = initializeBlocks(GRID_SIZE);
    }

    public Board(List<Block> newGame) {
        blocks = newGame;
    }

    @Override
    public List<Block> initializeBlocks(int remain) {
        if(remain == 0) return new ArrayList<>();

        List<Block> blocks = initializeBlocks(--remain);
        if (remain == 8) blocks.add(blocks.size(), new Block(remain, null));
        else blocks.add(blocks.size(), new Block(remain, String.valueOf(remain)));

        return blocks;
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

    public List<Block> getBlocks() {
        return blocks;
    }

    public int getEmptyBlockPosition() {
        for(Block block : blocks) {
            if (Objects.isNull(block.name)) return blocks.indexOf(block);
        };
        return -1;
    }

    public int getBlockPosition(String clickedBlock) {
        for(Block block : blocks) {
            if (!Objects.isNull(block.name) && block.name.equals(clickedBlock)) return blocks.indexOf(block);
        };
        return -1;
    }

}

