package net.wetnoodle.mcsnations.register;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.wetnoodle.mcsnations.MCSNConstants;

import java.util.ArrayList;
import java.util.List;

public class MCSNTrimMaterials {

    public static final List<ResourceKey<TrimMaterial>> TRIM_MATERIALS = new ArrayList<>();

    public static final ResourceKey<TrimMaterial> ECHO = register("echo");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        MCSNConstants.logWithModId("Initializing trim materials for ");
        register(context, ECHO, Style.EMPTY.withColor(0x1C99A3));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> key, Style style) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", key.location())).withStyle(style);
        context.register(key, new TrimMaterial(MaterialAssetGroup.create(key.location().getPath()), component));
    }

    private static ResourceKey<TrimMaterial> register(String name) {
        ResourceKey<TrimMaterial> key = ResourceKey.create(Registries.TRIM_MATERIAL, MCSNConstants.id(name));
        TRIM_MATERIALS.add(key);
        return key;
    }
}
