package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class BotUseItem {
    @SerializedName("item_id")
    private int itemId;

    // Constructor
    public BotUseItem(int itemId) {
        this.itemId = itemId;
    }
}
