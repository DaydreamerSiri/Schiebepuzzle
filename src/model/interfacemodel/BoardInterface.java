package model.interfacemodel;
import model.Block;
import java.util.List;

public interface BoardInterface<V> {

    int TOTAL_BLOCKS = 8 ; // 3 x 3 grid with 1 Space Free
    int GRID_SIZE = 9;

    List<V> initializeBlocks(int remain);
    Integer getBlockCount();
    Integer getGridSize();
}
