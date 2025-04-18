package cn.polarbear.mod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_STATUS_EFFECT_INSTANCE_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ModArmorMaterials.MOD_ITEM_1,
                            new StatusEffectInstance(StatusEffects.SPEED, 1000,
                                    1, false, false, true)).build();

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient) {
            if (entity instanceof PlayerEntity player && this.hasFullSuitOfArmor(player)) evaluateArmorEffects(player);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_STATUS_EFFECT_INSTANCE_MAP.entrySet()) {
            ArmorMaterial material = entry.getKey();
            StatusEffectInstance status = entry.getValue();
            if (hasCorrectArmorOn(material, player)) {
                AddStatusEffortForMaterial(status, material, player);
            }
        }
    }

    private void AddStatusEffortForMaterial(StatusEffectInstance status, ArmorMaterial material, PlayerEntity player) {
        boolean hasEffects = player.hasStatusEffect(status.getEffectType());

        if (hasCorrectArmorOn(material, player) && !hasEffects) {
            player.addStatusEffect(new StatusEffectInstance(status));
        }

    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();

        return boots.getMaterial() == material &&
               leggings.getMaterial() == material &&
               chestplate.getMaterial() == material &&
               helmet.getMaterial() == material;
    }

    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
