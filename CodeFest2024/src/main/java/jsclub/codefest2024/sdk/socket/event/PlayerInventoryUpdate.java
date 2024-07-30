package jsclub.codefest2024.sdk.socket.event;

import com.google.gson.Gson;
import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.Inventory;
import jsclub.codefest2024.sdk.model.InventoryUpdateData;
import jsclub.codefest2024.sdk.model.Items;

public class PlayerInventoryUpdate implements Emitter.Listener {
    InventoryUpdateData inventoryData = new InventoryUpdateData();
    Inventory inventory = new Inventory();
    private Gson gson = new Gson();

    @Override
    public void call(Object... args) {

        //            String message = MsgPackUtil.decodeMsgPackMessage(args[0]);
//            System.out.println("Inventory update from server: " + message);

        String json = (String) args[0];
        inventoryData = gson.fromJson(json, InventoryUpdateData.class);

        String player_name = inventoryData.player_name;
        Items item = inventoryData.item;
        String action = inventoryData.action;
        System.out.println("Message from server: " + inventoryData);

        if(player_name.equals(inventory.player_name)){
            if(action.equals("ADD")){
                inventory.INVENTORY.put(item, 1);
            }else if (action.equals("REMOVE")){
                inventory.INVENTORY.put(item, 0);
            }
        }

        System.out.println("Inventory update: " + inventory.toString());

    }

}
