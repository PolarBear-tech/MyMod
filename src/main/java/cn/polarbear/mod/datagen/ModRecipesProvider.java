package cn.polarbear.mod.datagen;

import cn.polarbear.mod.block.ModBlocks;
import cn.polarbear.mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MOD_ITEM_1_LIST = List.of(ModItems.MOD_ITEM_1);


    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.MOD_ITEM_1,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOD_BLOCK_1);

        offerSmelting(exporter, MOD_ITEM_1_LIST, RecipeCategory.MISC,
                ModItems.MOD_ITEM_2, 0.7f, 200, "mod_item_2");

        offerBlasting(exporter, MOD_ITEM_1_LIST, RecipeCategory.MISC,
                ModItems.MOD_ITEM_2, 0.7f, 100, "mod_item_2");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 3)
                .pattern("###")
                .input('#', Items.BEETROOT)
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, new Identifier("sugar_from_beetroot"));
    }
}
