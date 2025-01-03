package cn.polarbear.mod.item.custom;/**
 * @author PolarBear
 * @date 24.12.28
 */

import cn.polarbear.mod.Mod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Prospector extends Item {
    public Prospector(Settings settings) {
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
            BlockPos blockPos = context.getBlockPos();
            boolean foundBlock = false;
            for (int i = -64; i <= blockPos.getY() + 64; i++) {
                BlockState state = world.getBlockState(blockPos.down(i));
                if (isRightBlock(state)) {
                    outputMessage(blockPos.down(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock) {
                player.sendMessage(Text.literal("No block found!"), false);
            }
        }
        context.getStack().damage(1, player,
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        return ActionResult.SUCCESS;
    }

    private void outputMessage(BlockPos down, PlayerEntity player, Block block) {
        player.sendMessage(
                Text.literal("Found" + block.asItem().getName().getString() + "at"
                             + "(" + down.getX() + "," + down.getY() + "," + down.getZ() + ")!"), false
        );
    }

    private boolean isRightBlock(BlockState state) {
        return state.isOf(Blocks.IRON_BLOCK);
    }
}
