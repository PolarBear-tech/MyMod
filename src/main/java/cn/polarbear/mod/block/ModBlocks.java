package cn.polarbear.mod.block;

import cn.polarbear.mod.Mod;
import cn.polarbear.mod.block.custom.ModBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
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

    public static final Block MOD_BLOCK_3 = registerBlocks("mod_block_3",
            new ModBlock(FabricBlockSettings.copyOf(Blocks.STONE)));

    // 以下属于建筑方块
    // 楼梯
    public static final Block MOD_BLOCK_STAIR = registerBlocks("mod_block_stair",
            new StairsBlock(ModBlocks.MOD_BLOCK_1.getDefaultState(), FabricBlockSettings.copyOf(Blocks.STONE)));
    // 按钮
    public static final Block MOD_BLOCK_BUTTON = registerBlocks("mod_block_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE), BlockSetType.STONE, 20, true));
    // 半砖
    public static final Block MOD_BLOCK_SLAB = registerBlocks("mod_block_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    // 压力板
    public static final Block MOD_BLOCK_PRESSURE_PLATE = registerBlocks("mod_block_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.STONE),
                    BlockSetType.STONE)
    );
    // 栅栏
    public static final Block MOD_BLOCK_FENCE = registerBlocks("mod_block_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    // 栅栏门
    public static final Block MOD_BLOCK_FENCE_GATE = registerBlocks("mod_block_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.STONE),WoodType.OAK));
    // 墙
    public static final Block MOD_BLOCK_WALL = registerBlocks("mod_block_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE)));
    // 门
    public static final Block MOD_BLOCK_DOOR = registerBlocks("mod_block_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque(),BlockSetType.STONE));
    // 活板门
    public static final Block MOD_BLOCK_TRAPDOOR = registerBlocks("mod_block_trap_door",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.STONE).nonOpaque(), BlockSetType.STONE));
}
