package cn.polarbear.mod.datagen;

import cn.polarbear.mod.block.ModBlocks;
import cn.polarbear.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {
    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOD_BLOCK_1, ModItems.MOD_ITEM_1);

        addDrop(ModBlocks.MOD_BLOCK_BUTTON);
        addDrop(ModBlocks.MOD_BLOCK_FENCE);
        addDrop(ModBlocks.MOD_BLOCK_FENCE_GATE);
        addDrop(ModBlocks.MOD_BLOCK_DOOR);
        addDrop(ModBlocks.MOD_BLOCK_TRAPDOOR);
        addDrop(ModBlocks.MOD_BLOCK_STAIR);
        addDrop(ModBlocks.MOD_BLOCK_PRESSURE_PLATE);

        addDrop(ModBlocks.MOD_BLOCK_SLAB, slabDrops(ModBlocks.MOD_BLOCK_SLAB));
        addDrop(ModBlocks.MOD_BLOCK_WALL, doorDrops(ModBlocks.MOD_BLOCK_WALL));

        addDrop(ModBlocks.MOD_BLOCK_2, copperOreLikeDrops(ModBlocks.MOD_BLOCK_2, ModItems.MOD_ITEM_2));
    }


    public LootTable.Builder copperOreLikeDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
