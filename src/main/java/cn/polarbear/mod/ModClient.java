package cn.polarbear.mod;

import cn.polarbear.mod.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

/**
 * @author PolarBear
 * @date 24.12.27
 */
public class ModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap layerMap = BlockRenderLayerMap.INSTANCE;
        layerMap.putBlock(ModBlocks.MOD_BLOCK_DOOR, RenderLayer.getCutout());
        layerMap.putBlock(ModBlocks.MOD_BLOCK_DOOR, RenderLayer.getCutout());
    }
}
