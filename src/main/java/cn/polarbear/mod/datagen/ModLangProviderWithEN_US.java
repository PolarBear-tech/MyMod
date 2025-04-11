package cn.polarbear.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangProviderWithEN_US extends FabricLanguageProvider {
    public ModLangProviderWithEN_US(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("item.mod.mod_item_1","Mod Item 1");
        translationBuilder.add("item.mod.mod_item_2","Mod Item 2");
        translationBuilder.add("item.mod.prospector","Prospector");
        translationBuilder.add("item.mod.mod_food","Mod Food");
        translationBuilder.add("item.mod.fire_item","Fire Item");
        translationBuilder.add("item.mod.fuel","Fuel");
        translationBuilder.add("item.mod.fire_item.tooltip","This item is a fire source.");
        translationBuilder.add("itemGroup.mod_group","Mod");
        translationBuilder.add("block.mod.mod_block_1","Mod Block 1");
        translationBuilder.add("block.mod.mod_block_2","Mod Block 2");
        translationBuilder.add("block.mod.mod_block_3","Mod Block 3");
        translationBuilder.add("block.mod.fire_item","Fire Item");
        translationBuilder.add("block.mod.mod_block_stair","Mod Block Stair");
        translationBuilder.add("block.mod.mod_block_button","Mod Block Button");
        translationBuilder.add("block.mod.mod_block_slab","Mod Block Slab");
        translationBuilder.add("block.mod.mod_block_pressure_plate","Mod Block Pressure Plate");
        translationBuilder.add("block.mod.mod_block_fence","Mod Block Fence");
        translationBuilder.add("block.mod.mod_block_fence_gate","Mod Block Fence Gate");
        translationBuilder.add("block.mod.mod_block_wall","Mod Block Wall");
        translationBuilder.add("block.mod.mod_block_door","Mod Block Door");
        translationBuilder.add("block.mod.mod_block_trapdoor","Mod Block Trapdoor");
        translationBuilder.add("item.mod.mod_item_1_axe","Mod Block 1 Axe");
        translationBuilder.add("item.mod.mod_item_1_pickaxe","Mod Block 1 Pickaxe");
        translationBuilder.add("item.mod.mod_item_1_sword","Mod Block 1 Sword");
        translationBuilder.add("item.mod.mod_item_1_hoe","Mod Block 1 hoe");
        translationBuilder.add("item.mod.mod_item_1_shovel","Mod Block 1 Shovel");
        translationBuilder.add("item.mod.mod_item_1_helmet","Mod Item 1 Helmet");
        translationBuilder.add("item.mod.mod_item_1_chestplate","Mod Item 1 Chestplate");
        translationBuilder.add("item.mod.mod_item_1_leggings","Mod Item 1 Leggings");
        translationBuilder.add("item.mod.mod_item_1_boots","Mod Item 1 Boots");

    }
}
