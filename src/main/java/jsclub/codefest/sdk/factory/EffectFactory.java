package jsclub.codefest.sdk.factory;

import jsclub.codefest.sdk.model.Element;
import jsclub.codefest.sdk.model.effects.Effect;

import java.util.ArrayList;
import java.util.Map;

public class EffectFactory {
public static final Map<String, Effect> elementMap = Map.ofEntries(
        Map.entry("STUN", new Effect((float) -1, "STUN", 0)),
        Map.entry("INVISIBLE", new Effect((float)-1, "INVISIBLE", 0)),
        Map.entry("POISON", new Effect((float)-1, "POISON", 5)),
        Map.entry("BLEED", new Effect((float)3, "BLEED", 5)),
        Map.entry("PULL", new Effect((float)0, "PULL", 0)),
        Map.entry("BLIND", new Effect((float)-1, "BLIND", 0)),
        Map.entry("KNOCKBACK", new Effect((float)0, "KNOCKBACK", 0)),
        Map.entry("REVERSE", new Effect((float)10, "REVERSE", 0)),
        Map.entry("REVIVAL", new Effect((float)0, "REVIVAL", 0)),
        Map.entry("UNDEAD", new Effect((float)2, "UNDEAD", 0)),
        Map.entry("CONTROL_IMMUNITY", new Effect((float)7, "CONTROL_IMMUNITY", 0)),
        Map.entry("WEAPON_LOCKED", new Effect((float)20, "WEAPON_LOCKED", 0)),
        Map.entry("BUFF_DAMAGE", new Effect((float)-1, "BUFF_DAMAGE", 0))
);


    public static Effect getEffects(String id){
        return elementMap.get(id);
    }
}


