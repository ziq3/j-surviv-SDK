package jsclub.codefest2024.sdk.socket.event;

import com.google.gson.Gson;
import io.socket.emitter.Emitter;
import jsclub.codefest2024.sdk.model.Hero;
import jsclub.codefest2024.sdk.model.InventoryUpdateData;
import jsclub.codefest2024.sdk.model.Items;

public class onPlayerInventoryUpdate implements Emitter.Listener {
    private Hero hero;

    public onPlayerInventoryUpdate(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void call(Object... args) {

        Gson gson = new Gson();
        String json = (String) args[0];
        InventoryUpdateData inventoryData = new InventoryUpdateData();
        inventoryData = gson.fromJson(json, InventoryUpdateData.class);

        String playerName = inventoryData.playerName;
        Items item = inventoryData.item;
        String action = inventoryData.action;
        System.out.println("Message from server: " + inventoryData);

        if(playerName.equals(hero.getPlayerID())){
            if(action.equals("ADD")){
                hero.getInventory().put(item, hero.getInventory().get(item) + 1);
            }else if (action.equals("REMOVE")){
                hero.getInventory().put(item, hero.getInventory().get(item) - 1);
            }
        }

        System.out.println("Inventory update: " + hero.getInventory());

    }

}
