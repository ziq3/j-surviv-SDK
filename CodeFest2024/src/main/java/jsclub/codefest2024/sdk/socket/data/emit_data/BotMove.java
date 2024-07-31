package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class BotMove {
    @SerializedName("move")
    private String move;

    // Constructor
    public BotMove(String move) {
        this.move = move;
    }
}
