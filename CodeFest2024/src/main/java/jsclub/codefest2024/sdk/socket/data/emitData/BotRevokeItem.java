package jsclub.codefest2024.sdk.socket.data.emitData;

import com.google.gson.annotations.SerializedName;

public class BotRevokeItem {
    @SerializedName("item_id")
    private int itemId;

    // Constructor
    public BotRevokeItem(int itemId) {
        this.itemId = itemId;
    }
}
