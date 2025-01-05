package cn.polarbear.mod.util;

import cn.polarbear.mod.Mod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * @author PolarBear
 * @date 25.1.5
 */
public class ModTags {
    public static final class Blocks {
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Mod.MOD_ID, name));
        }

        public static final TagKey<Block> PROSPECTOR_LIST = createTag("prospector_list");
    }

    public static final class Items {

    }
}
