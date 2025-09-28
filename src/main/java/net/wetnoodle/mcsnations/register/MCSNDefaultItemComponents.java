package net.wetnoodle.mcsnations.register;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ProvidesTrimMaterial;
import net.wetnoodle.mcsnations.NationsConstants;

public class MCSNDefaultItemComponents {
//    public void onInitialize() {
//        ResourceLocation latePhase = ResourceLocation.fromNamespaceAndPath("fabric-item-api-v1-testmod", "late");
//        DefaultItemComponentEvents.MODIFY.addPhaseOrdering(Event.DEFAULT_PHASE, latePhase);
//
//        DefaultItemComponentEvents.MODIFY.register(context -> {
//            context.modify(Items.GOLD_INGOT, builder -> {
//                builder.set(DataComponents.ITEM_NAME, Component.literal("Fool's Gold").withStyle(ChatFormatting.GOLD));
//            });
//            context.modify(Items.GOLD_NUGGET, builder -> {
//                builder.set(DataComponents.FIREWORKS, new Fireworks(1, List.of(
//                        new FireworkExplosion(FireworkExplosion.Shape.STAR, IntList.of(0x32a852), IntList.of(0x32a852), true, true)
//                )));
//            });
//            context.modify(Items.BEEF, builder -> {
//                // Remove the food component from beef
//                builder.set(DataComponents.FOOD, null);
//            });
//            // add a word to the start of diamond pickaxe name
//            context.modify(Items.DIAMOND_PICKAXE, builder -> {
//                Component baseName = builder.getOrCreate(
//                        DataComponents.ITEM_NAME,
//                        Items.DIAMOND_PICKAXE::getName
//                );
//                builder.set(DataComponents.ITEM_NAME, prependModifiedLiteral(baseName));
//            });
//        });
//
//        // Make all fireworks glint
//        DefaultItemComponentEvents.MODIFY.register(latePhase, context -> {
//            context.modify(item -> item.getComponents().contains(DataComponentTypes.FIREWORKS), (builder, item) -> {
//                builder.set(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true);
//            });
//        });
//    }

    public static void init() {
        NationsConstants.logWithModId("Initializing item properties for ");
        ResourceLocation latePhase = ResourceLocation.fromNamespaceAndPath(NationsConstants.MOD_ID, "late");
        DefaultItemComponentEvents.MODIFY.addPhaseOrdering(Event.DEFAULT_PHASE, latePhase);

        DefaultItemComponentEvents.MODIFY.register(latePhase, context -> {
            context.modify(Items.ECHO_SHARD, builder -> {
                builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(MCSNTrimMaterials.ECHO));
            });
        });
    }
}
