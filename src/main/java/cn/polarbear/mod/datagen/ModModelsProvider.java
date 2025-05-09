package cn.polarbear.mod.datagen;

import cn.polarbear.mod.block.ModBlocks;
import cn.polarbear.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool modBlock1Pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOD_BLOCK_1);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOD_BLOCK_2);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOD_BLOCK_3);

        modBlock1Pool.stairs(ModBlocks.MOD_BLOCK_STAIR);
        modBlock1Pool.slab(ModBlocks.MOD_BLOCK_SLAB);
        modBlock1Pool.button(ModBlocks.MOD_BLOCK_BUTTON);
        modBlock1Pool.fence(ModBlocks.MOD_BLOCK_FENCE);
        modBlock1Pool.fenceGate(ModBlocks.MOD_BLOCK_FENCE_GATE);
        modBlock1Pool.pressurePlate(ModBlocks.MOD_BLOCK_PRESSURE_PLATE);
        modBlock1Pool.wall(ModBlocks.MOD_BLOCK_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.MOD_BLOCK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.MOD_BLOCK_TRAPDOOR);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOD_ITEM_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOD_ITEM_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOD_FOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.MOD_ITEM_1_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOD_ITEM_1_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOD_ITEM_1_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOD_ITEM_1_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOD_ITEM_1_SWORD, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOD_ITEM_1_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOD_ITEM_1_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOD_ITEM_1_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.MOD_ITEM_1_BOOTS);
    }
}
