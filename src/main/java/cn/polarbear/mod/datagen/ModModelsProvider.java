package cn.polarbear.mod.datagen;

import cn.polarbear.mod.block.ModBlocks;
import cn.polarbear.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOD_BLOCK_1);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOD_BLOCK_2);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOD_BLOCK_3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MOD_ITEM_1, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOD_ITEM_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.Mod_Food, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUEL, Models.GENERATED);

    }
}
