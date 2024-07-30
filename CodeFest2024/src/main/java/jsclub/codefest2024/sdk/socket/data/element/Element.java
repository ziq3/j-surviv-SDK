package jsclub.codefest2024.sdk.socket.data.element;

import com.google.gson.Gson;
import jsclub.codefest2024.sdk.socket.Position;

public class Element {
    private int row;
    private int col;

    public Element() {
        this.row = -1;
        this.col = -1;
    }

    public Element(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getPosition(){
        return new Gson().toJson(this);
    }

    public void setPosition (int row , int col){
        this.row = row;
        this.col = col;
    }

}
