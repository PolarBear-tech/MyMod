package cn.polarbear.mod.block;

import cn.polarbear.mod.Mod;
import cn.polarbear.mod.block.custom.ModBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static void registerModBlocks() {
    }

    private static Item registerBlockItems(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(Mod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()
                )
        );
    }

    private static Block registerBlocks(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(
                Registries.BLOCK,
                new Identifier(Mod.MOD_ID, name),
                block
        );
    }

    public static final Block MOD_BLOCK_1 = registerBlocks(
            "mod_block_1",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE))
    );

    public static final Block MOD_BLOCK_2 = registerBlocks(
            "mod_block_2",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE))
    );

    public static final Block MOD_BLOCK_3 = registerBlocks(
            "mod_block_3",
            new ModBlock(FabricBlockSettings.copyOf(Blocks.STONE))
    );
}
