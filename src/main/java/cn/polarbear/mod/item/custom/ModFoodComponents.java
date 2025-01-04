package cn.polarbear.mod.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

/**
 * @author PolarBear
 * @date 25.1.4
 */
public class ModFoodComponents {
    public static final FoodComponent ModFood = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 0.2f)
            .build();
}
