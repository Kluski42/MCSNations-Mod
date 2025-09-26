package net.wetnoodle.mcsnations.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.ItemTags.TRIM_MATERIALS;

public class MCSNItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public MCSNItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(TRIM_MATERIALS).add(Items.ECHO_SHARD);
    }
}
