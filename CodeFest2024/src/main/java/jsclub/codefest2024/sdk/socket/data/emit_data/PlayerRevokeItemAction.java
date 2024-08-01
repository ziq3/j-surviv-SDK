package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class PlayerRevokeItemAction {
    @SerializedName("item_id")
    private int itemId;

    // Constructor
    public PlayerRevokeItemAction(int itemId) {
        this.itemId = itemId;
    }
}
