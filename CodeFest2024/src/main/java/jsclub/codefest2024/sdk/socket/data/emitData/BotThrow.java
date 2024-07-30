package jsclub.codefest2024.sdk.socket.data.emitData;

import com.google.gson.annotations.SerializedName;

public class BotThrow {
    @SerializedName("item_id")
    private int item_id;

    @SerializedName("destination_x")
    private int destination_x;

    @SerializedName("destination_y")
    private int destination_y;

    // Constructor
    public BotThrow(int item_id, int destination_x, int destination_y) {
        this.item_id = item_id;
        this.destination_x = destination_x;
        this.destination_y = destination_y;
    }
}
