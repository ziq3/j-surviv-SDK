package jsclub.codefest.sdk.socket.event_handler;

import io.socket.emitter.Emitter;
import jsclub.codefest.sdk.model.Inventory;

public class onplayerInventoryClear implements Emitter.Listener {
    private final Inventory inventory;

    public onplayerInventoryClear(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void call(Object... args) {
        inventory.updateOnInventoryClear(args[0]);
    }
}
