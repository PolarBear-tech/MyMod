package cn.polarbear.mod.util;

import cn.polarbear.mod.Mod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final class Blocks {
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Mod.MOD_ID, name));
        }

        public static final TagKey<Block> PROSPECTOR_LIST = createTag("prospector_list");
    }

    public static final class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Mod.MOD_ID, name));
        }

    }
}
