package net.wetnoodle.mcsnations.register;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.wetnoodle.mcsnations.NationsConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MCSNTrimMaterials {

    public static final ResourceKey<TrimMaterial> ECHO = registryKey("echo");

    public static void init() {
        NationsConstants.logWithModId("Initializing trim materials for ");
    }

    private static ResourceKey<TrimMaterial> registryKey(String path) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, NationsConstants.id(path));
    }
}
