package jsclub.codefest2024.sdk.socket.event_handler;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.socket.EventName;
import jsclub.codefest2024.sdk.socket.data.emit_data.TestBotAction;
import jsclub.codefest2024.sdk.util.MsgPackUtil;

import java.io.IOException;
import java.util.Date;

public class onTestGameReceive implements Emitter.Listener {
    private final io.socket.client.Socket socket;

    public onTestGameReceive(io.socket.client.Socket socket) {
        this.socket = socket;
    }

    @Override
    public void call(Object... args) {
        try {
            String message = MsgPackUtil.decode(args[0]);
            System.out.println("Message from server: " + message);

            // Emit bot action with current time
            TestBotAction testBotAction = new TestBotAction(new Date().toString(), "player1", 1);

            byte[] bytes = MsgPackUtil.encodeFromObject(testBotAction);
            socket.emit(EventName.EMIT_TEST_GAME, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
