package jsclub.codefest2024.sdk.socket.data.emitData;

import com.google.gson.annotations.SerializedName;

public class BotThrow {
    @SerializedName("item_id")
    private int itemId;

    @SerializedName("destination_x")
    private int destinationX;

    @SerializedName("destination_y")
    private int destinationY;

    // Constructor
    public BotThrow(int itemId, int destinationX, int destinationY) {
        this.itemId = itemId;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }
}
