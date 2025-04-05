package cn.polarbear.mod.item;

import cn.polarbear.mod.Mod;
import cn.polarbear.mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static void registerModItemGroup() {
    }

    public static final ItemGroup MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mod.MOD_ID, "mod_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.mod_group"))
                    .icon(() -> new ItemStack(ModItems.MOD_ITEM_1))
                    .entries((displayContext, entries) -> {
                                entries.add(ModItems.MOD_ITEM_1);
                                entries.add(ModItems.MOD_ITEM_2);
                                entries.add(ModItems.PROSPECTOR);
                                entries.add(ModItems.FIRE_ITEM);
                                entries.add(ModItems.Mod_Food);
                                entries.add(ModItems.FUEL);
                                entries.add(ModBlocks.MOD_BLOCK_1);
                                entries.add(ModBlocks.MOD_BLOCK_2);
                                entries.add(ModBlocks.MOD_BLOCK_3);
                                entries.add(ModBlocks.MOD_BLOCK_STAIR);
                                entries.add(ModBlocks.MOD_BLOCK_SLAB);
                                entries.add(ModBlocks.MOD_BLOCK_BUTTON);
                                entries.add(ModBlocks.MOD_BLOCK_PRESSURE_PLATE);
                                entries.add(ModBlocks.MOD_BLOCK_FENCE);
                                entries.add(ModBlocks.MOD_BLOCK_FENCE_GATE);
                                entries.add(ModBlocks.MOD_BLOCK_DOOR);
                                entries.add(ModBlocks.MOD_BLOCK_TRAPDOOR);
                                entries.add(ModBlocks.MOD_BLOCK_WALL);
                            }
                    ).build()
    );

}
