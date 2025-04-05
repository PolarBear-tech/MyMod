package cn.polarbear.mod.item;

import cn.polarbear.mod.Mod;
import cn.polarbear.mod.item.custom.FireItem;
import cn.polarbear.mod.item.custom.ModFoodComponents;
import cn.polarbear.mod.item.custom.ModToolMaterial;
import cn.polarbear.mod.item.custom.Prospector;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void registerModItems() {
    }

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

    public static final Item MOD_FOOD = registerItems("mod_food",
            new Item(new FabricItemSettings().food(ModFoodComponents.ModFood)));

    public static final Item FUEL = registerItems("fuel",
            new Item(new FabricItemSettings()));

    public static final Item MOD_ITEM_1_PICKAXE = registerItems("mod_item_1_pickaxe",
            new PickaxeItem(ModToolMaterial.MOD_ITEM_1, 2, 2f, new FabricItemSettings()));

    public static final Item MOD_ITEM_1_AXE = registerItems("mod_item_1_axe",
            new AxeItem(ModToolMaterial.MOD_ITEM_1, 2, 2f, new FabricItemSettings()));

    public static final Item MOD_ITEM_1_SHOVEL = registerItems("mod_item_1_shovel",
            new ShovelItem(ModToolMaterial.MOD_ITEM_1, 2, 2f, new FabricItemSettings()));

    public static final Item MOD_ITEM_1_SWORD = registerItems("mod_item_1_sword",
            new PickaxeItem(ModToolMaterial.MOD_ITEM_1, 2, 2f, new FabricItemSettings()));

    public static final Item MOD_ITEM_1_HOE = registerItems("mod_item_1_hoe",
            new PickaxeItem(ModToolMaterial.MOD_ITEM_1, 2, 2f, new FabricItemSettings()));
}
