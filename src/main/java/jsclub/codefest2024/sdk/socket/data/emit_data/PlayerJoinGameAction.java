package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class PlayerJoinGameAction {
    @SerializedName("joinCode")
    private String gameID;

    public PlayerJoinGameAction(String gameID) {
        this.gameID = gameID;
    }
}
