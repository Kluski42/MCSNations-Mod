package net.wetnoodle.mcsnations.register;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.wetnoodle.mcsnations.MCSNConstants;

public class MCSNItemTags {
    public static final TagKey<Item> HAPPY_GHAST_TRUE_TEMPT_ITEMS = register(Registries.ITEM, "happy_ghast_true_tempt");

    public static void init() {
        MCSNConstants.logWithModId("Registering item tags for ");
    }

    private static <T> TagKey<T> register(ResourceKey<Registry<T>> registry, String name) {
        return TagKey.create(registry, MCSNConstants.id(name));
    }
}
