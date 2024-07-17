package jsclub.codefest2024.socket.data.Obstacles;

public class Obstacle {
    private int endurance;
    private int length;
    private int width;
    private String type;

    public Obstacle(int endurance, int length, int width, String type) {
        this.endurance = endurance;
        this.length = length;
        this.width = width;
        this.type = type;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
