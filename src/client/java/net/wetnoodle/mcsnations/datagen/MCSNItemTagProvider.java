package net.wetnoodle.mcsnations.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.wetnoodle.mcsnations.register.MCSNItemTags;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.ItemTags.HAPPY_GHAST_TEMPT_ITEMS;
import static net.minecraft.tags.ItemTags.TRIM_MATERIALS;

public class MCSNItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public MCSNItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(TRIM_MATERIALS).add(Items.ECHO_SHARD);
        valueLookupBuilder(TRIM_MATERIALS).add(Items.NETHERITE_SCRAP);
        valueLookupBuilder(TRIM_MATERIALS).add(Items.POPPED_CHORUS_FRUIT);
        valueLookupBuilder(TRIM_MATERIALS).add(Items.PRISMARINE_CRYSTALS);

        valueLookupBuilder(MCSNItemTags.HAPPY_GHAST_TRUE_TEMPT_ITEMS).add(Items.SNOW_BLOCK, Items.SNOW, Items.POWDER_SNOW_BUCKET);
        valueLookupBuilder(HAPPY_GHAST_TEMPT_ITEMS).addTag(MCSNItemTags.HAPPY_GHAST_TRUE_TEMPT_ITEMS);
    }
}
