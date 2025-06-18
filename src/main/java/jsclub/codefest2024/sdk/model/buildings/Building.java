package jsclub.codefest2024.sdk.model.buildings;

import jsclub.codefest2024.sdk.base.Node;
import jsclub.codefest2024.sdk.model.Element;

import java.util.ArrayList;
import java.util.List;

public class Building extends Element {
    private ShapeType shapeType;
    private Node limitPos; // toa do gioi han (goc duoi ben phai)
    private Node landmarkPos; // toa do moc (goc tren ben trai)

    public Building(String id, ShapeType shapeType) {
        super(id);
        this.shapeType = shapeType;
    }

    public Building(String id, ShapeType shapeType, Node limitPos, Node landmarkPos) {
        super(id);
        this.shapeType = shapeType;
        this.limitPos = limitPos;
        this.landmarkPos = landmarkPos;
    }

    public Node getCenter() {
        int x = (this.limitPos.getX() + this.landmarkPos.getX())/2;
        int y = (this.limitPos.getY() + this.landmarkPos.getY())/2;
        return new Node(x, y);
    }

    public List<Node> getWall () {
        List<Node> wall = new ArrayList<>();
        for (int i = landmarkPos.getX(); i <= limitPos.getX(); i++) {
            wall.add(new Node(i, landmarkPos.getY()));
            wall.add(new Node(i, limitPos.getY()));
        }
        for (int i = limitPos.getY(); i <= landmarkPos.getY(); i++) {
            wall.add(new Node(landmarkPos.getX(), i));
            wall.add(new Node(limitPos.getX(), i));
        }
        return wall;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public Node getLimitPos() {
        return limitPos;
    }

    public Node getLandmarkPos() {
        return landmarkPos;
    }

    public void setLandmarkPos(Node landmarkPos) {
        this.landmarkPos = landmarkPos;
    }

    public void setLimitPos(Node limitPos) {
        this.limitPos = limitPos;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
