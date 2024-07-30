package jsclub.codefest2024.sdk.socket.event;

import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.Inventory;
import jsclub.codefest2024.sdk.util.MsgPackUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PlayerInventoryUpdate implements Emitter.Listener {
    private Map<Inventory.Items, Integer> inventory = Inventory.INVENTORY;

    @Override
    public void call(Object... args) {
        try {
            String message = MsgPackUtil.decodeMsgPackMessage(args[0]);
            System.out.println("Inventory update from server: " + message);
            // ...
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addItems(Inventory.Items item, int quantity){
        inventory.put(item, inventory.get(item) + quantity);
    }

    public void removeItems(Inventory.Items item){
        if(inventory.containsKey(item)){
            inventory.put(item, 0);
        }
    }

    public Map<Inventory.Items, Integer> getAllItems(){
        return new HashMap<>(inventory);
    }

    public int getItemInfo(String item){
        return inventory.get(item);
    }
}
