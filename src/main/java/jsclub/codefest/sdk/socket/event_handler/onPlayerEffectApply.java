package jsclub.codefest.sdk.socket.event_handler;

import com.google.gson.Gson;
import io.socket.emitter.Emitter;
import jsclub.codefest.sdk.model.effects.Effect;
import jsclub.codefest.sdk.util.MsgPackUtil;

import java.io.IOException;

public class onPlayerEffectApply implements Emitter.Listener {
    Gson gson = new Gson();

    @Override
    public void call(Object... args) {
        try {
            String message = MsgPackUtil.decode(args[0]);
            Effect effect = gson.fromJson(message, Effect.class);
            System.out.println("Effect applied: " + effect);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
