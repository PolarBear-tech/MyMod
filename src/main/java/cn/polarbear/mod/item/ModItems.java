package cn.polarbear.mod.item;

import cn.polarbear.mod.Mod;
import cn.polarbear.mod.item.custom.FireItem;
import cn.polarbear.mod.item.custom.ModFoodComponents;
import cn.polarbear.mod.item.custom.Prospector;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author PolarBear
 * @date 24.12.27
 */
public class ModItems {
    public static void registerModItems() {}

    public static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM,
                new Identifier(Mod.MOD_ID, name),
                item);
    }

    public static final Item MOD_ITEM_1 = registerItems("mod_item_1",
            new Item(new FabricItemSettings()));

    public static final Item MOD_ITEM_2 = registerItems("mod_item_2",
            new Item(new FabricItemSettings()));

    public static final Item PROSPECTOR = registerItems("prospector",
            new Prospector(new FabricItemSettings().maxDamage(64)));

    public static final Item FIRE_ITEM = registerItems("fire_item",
            new FireItem(new FabricItemSettings().maxDamage(64)));

    public static final Item Mod_Food = registerItems("mod_food",
            new Item(new FabricItemSettings().food(ModFoodComponents.ModFood)));

    public static final Item FUEL = registerItems("fuel",
            new Item(new FabricItemSettings()));
}
