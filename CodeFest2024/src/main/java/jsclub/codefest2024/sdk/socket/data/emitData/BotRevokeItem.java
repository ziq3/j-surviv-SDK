package jsclub.codefest2024.sdk.socket.data.emitData;

import com.google.gson.annotations.SerializedName;

public class BotRevokeItem {
    @SerializedName("item_id")
    private int item_id;

    // Constructor
    public BotRevokeItem(int item_id) {
        this.item_id = item_id;
    }
}
