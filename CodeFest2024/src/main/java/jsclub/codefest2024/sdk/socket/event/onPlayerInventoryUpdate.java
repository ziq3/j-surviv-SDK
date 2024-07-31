package jsclub.codefest2024.sdk.socket.event;

import com.google.gson.Gson;
import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.Hero;
import jsclub.codefest2024.sdk.model.InventoryUpdateData;
import jsclub.codefest2024.sdk.model.Items;

public class onPlayerInventoryUpdate implements Emitter.Listener {
    InventoryUpdateData inventoryData = new InventoryUpdateData();
    private Hero hero;

    public onPlayerInventoryUpdate(Hero hero) {
        this.hero = hero;
    }

    private Gson gson = new Gson();

    @Override
    public void call(Object... args) {


        String json = (String) args[0];
        inventoryData = gson.fromJson(json, InventoryUpdateData.class);

        String player_name = inventoryData.player_name;
        Items item = inventoryData.item;
        String action = inventoryData.action;
        System.out.println("Message from server: " + inventoryData);

        if(player_name.equals(hero.getPlayerID())){
            if(action.equals("ADD")){
                hero.getInventory().put(item, 1);
            }else if (action.equals("REMOVE")){
                hero.getInventory().put(item, 0);
            }
        }

        System.out.println("Inventory update: " + hero.getInventory());

    }

}
