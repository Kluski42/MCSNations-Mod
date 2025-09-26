package net.wetnoodle.mcsnations;

import net.fabricmc.api.ModInitializer;

import net.wetnoodle.mcsnations.register.MCSNDefaultItemComponents;
import net.wetnoodle.mcsnations.register.MCSNTrimMaterials;

public class MCSNations implements ModInitializer {

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
//        MCSNTrimMaterials.init();
        MCSNDefaultItemComponents.init();
    }
}