package jsclub.codefest2024.bot;

import jsclub.codefest2024.sdk.model.Hero;

public class Main {
    private static final String SERVER_URL = "http://localhost:3000";

    public static void main(String[] args) {
        Hero hero = new Hero("player1", "game1");
        hero.start(SERVER_URL);
    }
}
