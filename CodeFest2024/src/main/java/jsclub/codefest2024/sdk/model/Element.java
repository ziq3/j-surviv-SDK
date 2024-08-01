package jsclub.codefest2024.sdk.model;

import com.google.gson.Gson;

public class Element {
    private int x;
    private int y;
    private String id;
    private ElementType type = ElementType.ROAD;

    public Element(String id) {
        this.id = id;
    }

    public Element(int x, int y, String id, ElementType type) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.type = type;
    }

    public Element() {}

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getId() {
        return id;
    }
    public ElementType getType() {
        return type;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
