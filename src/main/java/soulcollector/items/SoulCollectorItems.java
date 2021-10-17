package soulcollector.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import soulcollector.MainClassMod;
import soulcollector.items.base.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class SoulCollectorItems {
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item STEEL_INGOT = add("steel_ingot", new BaseItem(settings1()));
    public static final Item SOUL_INGOT = add("soul_ingot", new SoulIngot(settings1()));
    public static final Item BEBROCK = add("bebrock_ingot", new Bebrock(settings1()));
    public static final Item PIG_CROWN = add("pig_crown", new TechnoCrown(settings1()));
    public static final Item ANCIENT_SOUL = add("ancient_soul", new AncientSoul(settings1()));
    public static final Item INACTIVE_SINGULARITY = add("inactive_singularity", new Singularity(settings1()));
    public static final Item FRIENDLY_SINGULARITY = add("fren_singularity", new Singularity(settings1()));
    public static final Item PEACEFUL_SINGULARITY = add("peaceful_singularity", new Singularity(settings1()));
    public static final Item HARMFUL_SINGULARITY = add("harmful_singularity", new Singularity(settings1()));
    public static final Item HOSTILE_SINGULARITY = add("hostile_singularity", new Singularity(settings1()));

    public static final Item CHICKEN_SOUL = add("chicken_soul", new BaseItem(settings()));
    public static final Item COW_SOUL = add("cow_soul", new BaseItem(settings()));
    public static final Item SHEEP_SOUL = add("sheep_soul", new BaseItem(settings()));
    public static final Item PIG_SOUL = add("pig_soul", new BaseItem(settings()));
    public static final Item SQUID_SOUL = add("squid_soul", new BaseItem(settings()));
    public static final Item MOOSHROOM_SOUL = add("mooshroom_soul", new BaseItem(settings()));
    public static final Item VILLAGER_SOUL = add("villager_soul", new BaseItem(settings()));
    public static final Item OCELOT_SOUL = add("ocelot_soul", new BaseItem(settings()));
    public static final Item RABBIT_SOUL = add("rabbit_soul", new BaseItem(settings()));

    public static final Item ZOMBIE_SOUL = add("zombie_soul", new BaseItem(settings()));
    public static final Item SKELETON_SOUL = add("skeleton_soul", new BaseItem(settings()));
    public static final Item SPIDER_SOUL = add("spider_soul", new BaseItem(settings()));
    public static final Item CREEPER_SOUL = add("awman_soul", new BaseItem(settings()));
    public static final Item PHANTOM_SOUL = add("phantom_soul", new BaseItem(settings()));
    public static final Item ENDERMAN_SOUL = add("enderman_soul", new BaseItem(settings()));
    public static final Item ELDER_GUARDIAN_SOUL = add("elder_guardian_soul", new BaseItem(settings()));
    public static final Item SHULKER_SOUL = add("shulker_soul", new BaseItem(settings()));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(MainClassMod.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings1(){
        return new FabricItemSettings().group(MainClassMod.ITEM_GROUP_ITEMS);
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(MainClassMod.ITEM_GROUP_SOULS);
    }

    public static void register() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
    }
}
