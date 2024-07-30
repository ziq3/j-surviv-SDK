package jsclub.codefest2024.sdk.socket.event;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.util.MsgPackUtil;

import java.io.IOException;

public class onTestGameReceive implements Emitter.Listener {
    @Override
    public void call(Object... args) {
        try {
            String message = MsgPackUtil.decodeMsgPackMessage(args[0]);
            System.out.println("Message from server: " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
