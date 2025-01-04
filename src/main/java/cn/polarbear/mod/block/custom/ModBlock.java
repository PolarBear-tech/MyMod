package cn.polarbear.mod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;

public class ModBlock extends Block {

    public ModBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setFireTicks(200);


        super.onEntityLand(world, entity);

    }
}
