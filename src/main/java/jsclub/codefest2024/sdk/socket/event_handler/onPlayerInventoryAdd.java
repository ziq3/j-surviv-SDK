package jsclub.codefest2024.sdk.socket.event_handler;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.Inventory;

public class onPlayerInventoryAdd implements Emitter.Listener {
    private final Inventory inventory;

    public onPlayerInventoryAdd(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void call(Object... args) {
        inventory.updateOnInventoryAdd(args[0]);
    }
}
