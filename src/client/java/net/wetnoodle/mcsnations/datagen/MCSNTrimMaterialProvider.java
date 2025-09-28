package net.wetnoodle.mcsnations.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.wetnoodle.mcsnations.register.MCSNTrimMaterials;

import java.util.concurrent.CompletableFuture;


public class MCSNTrimMaterialProvider extends FabricDynamicRegistryProvider {
    public MCSNTrimMaterialProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
        super(output, future);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        MCSNTrimMaterials.TRIM_MATERIALS.forEach((key) -> add(provider, entries, key));
    }

    private void add(HolderLookup.Provider provider, Entries entries, ResourceKey<TrimMaterial> key) {
        entries.add(key, provider.lookupOrThrow(Registries.TRIM_MATERIAL).getOrThrow(key).value());
    }

    @Override
    public String getName() {
        return "Trim Materials";
    }
}
