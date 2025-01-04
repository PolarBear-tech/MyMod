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

/**
 * @author PolarBear
 * @date 24.12.27
 */
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
                                entries.add(ModBlocks.MOD_BLOCK_1);
                                entries.add(ModBlocks.MOD_BLOCK_2);
                                entries.add(ModBlocks.MOD_BLOCK_3);
                            }
                    ).build()
    );

}
