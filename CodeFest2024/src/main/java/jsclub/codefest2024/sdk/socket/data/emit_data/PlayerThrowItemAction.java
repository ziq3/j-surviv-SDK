package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class PlayerThrowItemAction {
    @SerializedName("item_id")
    private int itemId;

    @SerializedName("destination_x")
    private int destinationX;

    @SerializedName("destination_y")
    private int destinationY;

    // Constructor
    public PlayerThrowItemAction(int itemId, int destinationX, int destinationY) {
        this.itemId = itemId;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }
}
