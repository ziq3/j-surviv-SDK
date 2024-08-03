package jsclub.codefest2024.sdk.socket;

public class EventName {
    public static final String ON_TEST_GAME_RECEIVE = "game:map:update";
    public static final String ON_MAP_UPDATE = "game:on-map-updated";
    public static final String ON_MAP_INIT = "game:send-map-infomation";
    public static final String ON_INVENTORY_UPDATE = "sdk:on-player-inventory-updated";

    public static final String EMIT_JOIN_GAME = "sdk:join-game";

    public static final String EMIT_MOVE = "skd:move";
    public static final String EMIT_SHOOT = "sdk:shoot";
    public static final String EMIT_ATTACK = "sdk:attack";
    public static final String EMIT_THROW = "sdk:throw";
    public static final String EMIT_PICKUP_ITEM = "sdk:pickup-item";
    public static final String EMIT_USE_ITEM = "sdk:use-item";
    public static final String EMIT_REVOKE_ITEM = "sdk:revoke-item";
}
