package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class PlayerUseItemAction {
    @SerializedName("slot")
    private String slot;

    public PlayerUseItemAction(String slot) {
        this.slot = slot;
    }
}
