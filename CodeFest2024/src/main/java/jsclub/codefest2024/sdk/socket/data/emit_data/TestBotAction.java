package jsclub.codefest2024.sdk.socket.data.emit_data;

import com.google.gson.annotations.SerializedName;

public class TestBotAction {
    @SerializedName("time")
    private String time;

    @SerializedName("clientID")
    private String clientID;

    @SerializedName("actionId")
    private int actionId;

    // Constructor
    public TestBotAction(String time, String clientID, int actionId) {
        this.time = time;
        this.clientID = clientID;
        this.actionId = actionId;
    }
}