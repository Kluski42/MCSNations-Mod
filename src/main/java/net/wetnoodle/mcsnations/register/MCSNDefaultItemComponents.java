package net.wetnoodle.mcsnations.register;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ProvidesTrimMaterial;
import net.wetnoodle.mcsnations.MCSNConstants;

public class MCSNDefaultItemComponents {
    public static void init() {
        MCSNConstants.logWithModId("Registering item properties for ");
        ResourceLocation latePhase = ResourceLocation.fromNamespaceAndPath(MCSNConstants.MOD_ID, "late");
        DefaultItemComponentEvents.MODIFY.addPhaseOrdering(Event.DEFAULT_PHASE, latePhase);

        DefaultItemComponentEvents.MODIFY.register(latePhase, context -> {
            context.modify(Items.ECHO_SHARD, builder -> {
                builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(MCSNTrimMaterials.ECHO));
            });
            context.modify(Items.NETHERITE_SCRAP, builder -> {
                builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(MCSNTrimMaterials.SCRAP));
            });
            context.modify(Items.POPPED_CHORUS_FRUIT, builder -> {
                builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(MCSNTrimMaterials.PURPUR));
            });
            context.modify(Items.PRISMARINE_CRYSTALS, builder -> {
                builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(MCSNTrimMaterials.PRISMARINE));
            });
        });
    }
}
