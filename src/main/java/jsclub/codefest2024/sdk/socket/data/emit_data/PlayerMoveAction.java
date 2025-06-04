package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class PlayerMoveAction {
    @SerializedName("route")
    private String move;

    public PlayerMoveAction(String move) {
        this.move = move;
    }
}
