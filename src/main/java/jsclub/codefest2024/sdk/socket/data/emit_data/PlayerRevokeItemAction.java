package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class PlayerRevokeItemAction {
    @SerializedName("itemId")
    private String itemId;

    public PlayerRevokeItemAction(String itemId) {
        this.itemId = itemId;
    }
}
