package jsclub.codefest.sdk.model.doors;

import jsclub.codefest.sdk.base.Node;
import jsclub.codefest.sdk.model.ElementType;
import jsclub.codefest.sdk.model.obstacles.Obstacle;
import jsclub.codefest.sdk.model.obstacles.ObstacleTag;

import java.util.ArrayList;
import java.util.Arrays;

public class Portal extends Obstacle {
    private Node otherSidePos;

    public Portal(Node otherSidePos, ElementType type) {
        super("PORTAL", type, new ArrayList<>(Arrays.asList(ObstacleTag.CAN_GO_THROUGH, ObstacleTag.PULLABLE_ROPE)));
        this.otherSidePos = otherSidePos;
    }

    public Node getOtherSidePos() {
        return otherSidePos;
    }

    public void setOtherSidePos(Node otherSidePos) {
        this.otherSidePos = otherSidePos;
    }
}
