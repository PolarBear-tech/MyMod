package cn.polarbear.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModLangProviderWithZN_CH extends FabricLanguageProvider {
    public ModLangProviderWithZN_CH(FabricDataOutput dataOutput) {
        super(dataOutput, "zn_ch");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("block.mod.mod_block_1","Mod Block 1");
    }
}
