package jsclub.codefest2024.sdk.socket;

import com.google.gson.Gson;

public class Position {
    public static final int LEFT_POSITION = 1;
    public static final int RIGHT_POSITION = 2;
    public static final int UP_POSITION = 3;
    public static final int DOWN_POSITION = 4;

    private int col;
    private int row;

    public Position(int col, int row) {
        this.row = row;
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public Position nextPosition(int direction, int step) {
        switch (direction) {
            case LEFT_POSITION:
                return new Position(col - step, row);
            case RIGHT_POSITION:
                return new Position(col + step, row);
            case UP_POSITION:
                return new Position(col, row - step);
            case DOWN_POSITION:
                return new Position(col, row + step);
            default:
                return new Position(col, row);
        }
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
