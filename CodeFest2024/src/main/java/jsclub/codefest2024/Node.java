package jsclub.codefest2024;

import static java.lang.Math.abs;

public class Node {
    public int x;
    public int y;
    public int g;

    public Node() {}
    public Node(int x, int y, int g) {
        this.x = x;
        this.y = y;
        this.g = g;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int mahattanDistance(Node x, Node y) {
        return abs(x.x - y.x) + abs(x.y - y.y);
    }

    public int calculateF(Node x, Node y) {
        return x.g + mahattanDistance(x, y);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
