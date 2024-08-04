package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class PlayerUseItemAction {
    @SerializedName("item_id")
    private int itemId;

    // Constructor
    public PlayerUseItemAction(int itemId) {
        this.itemId = itemId;
    }
}
