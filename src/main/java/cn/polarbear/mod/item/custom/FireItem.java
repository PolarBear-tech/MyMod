package cn.polarbear.mod.item.custom;

import cn.polarbear.mod.Mod;
import cn.polarbear.mod.block.ModBlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireItem extends Item {
    public FireItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (player == null) {
            Mod.LOGGER.warn("Player is null!");
            return ActionResult.PASS;
        }
        if (!world.isClient) {
            ItemStack stack = context.getStack();
            BlockState blockState = world.getBlockState(context.getBlockPos());
            lightFire(blockState, context, player);
            stack.damage(1, player, playerEntity -> {
                playerEntity.sendToolBreakStatus(playerEntity.getActiveHand());
            });
        }

        return ActionResult.SUCCESS;
    }

    private void lightFire(BlockState blockState, ItemUsageContext context, PlayerEntity player) {
        boolean playerNotOnFire = !player.isOnFire();
        World world = context.getWorld();
        if (world.getRandom().nextFloat() > 0.5f) {
            lightEntityOnFire(player, 200);
        } else if (playerNotOnFire && blockIsRight(blockState)) {
            gainFireProtectionAndDestroyBlock(player, world, context.getBlockPos());
        } else {
            lightGround(context);
        }
    }

    private void lightGround(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockPos offset = blockPos.offset(context.getSide());
        if (AbstractFireBlock.canPlaceAt(world,offset,context.getHorizontalPlayerFacing())){
            world.playSound(player,
                    offset,
                    SoundEvents.ITEM_FLINTANDSTEEL_USE,
                    SoundCategory.BLOCKS,
                    1.0F,
                    world.getRandom().nextFloat() * 0.4F + 0.8F);
            BlockState state = AbstractFireBlock.getState(world, offset);
            world.setBlockState(offset,state, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
            world.emitGameEvent(player, GameEvent.BLOCK_PLACE,blockPos);
        }
    }

    private void gainFireProtectionAndDestroyBlock(PlayerEntity player, World world, BlockPos blockPos) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200));
        world.breakBlock(blockPos,false);
    }

    private boolean blockIsRight(BlockState blockState) {
        return blockState.isOf(ModBlocks.MOD_BLOCK_1);
    }

    private void lightEntityOnFire(PlayerEntity player, int i) {
        player.setFireTicks(i);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.mod.fire_item.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
