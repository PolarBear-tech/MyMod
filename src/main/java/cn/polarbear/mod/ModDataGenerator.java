package cn.polarbear.mod;

import cn.polarbear.mod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModLootTablesProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLangProviderWithEN_US::new);
		pack.addProvider(ModLangProviderWithZN_CH::new);
	}
}
