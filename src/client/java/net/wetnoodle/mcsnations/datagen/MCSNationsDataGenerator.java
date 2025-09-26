package net.wetnoodle.mcsnations.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.wetnoodle.mcsnations.register.MCSNTrimMaterials;

public class MCSNationsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(MCSNTrimMaterialProvider::new);
        pack.addProvider(MCSNItemTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder builder) {
        builder.add(Registries.TRIM_MATERIAL, MCSNTrimMaterials::bootstrap);
    }
}
