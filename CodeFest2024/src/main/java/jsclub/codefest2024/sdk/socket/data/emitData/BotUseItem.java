package jsclub.codefest2024.sdk.socket.data.emitData;

import com.google.gson.annotations.SerializedName;

public class BotUseItem {
    @SerializedName("item_id")
    private int item_id;

    // Constructor
    public BotUseItem(int item_id) {
        this.item_id = item_id;
    }
}
