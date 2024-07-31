package jsclub.codefest2024.sdk.socket.data.emitData;

import com.google.gson.annotations.SerializedName;

public class BotUseItem {
    @SerializedName("item_id")
    private int itemId;

    // Constructor
    public BotUseItem(int itemId) {
        this.itemId = itemId;
    }
}
