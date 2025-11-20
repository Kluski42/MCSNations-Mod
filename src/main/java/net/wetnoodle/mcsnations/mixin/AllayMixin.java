package net.wetnoodle.mcsnations.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.CustomModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

@Mixin(Allay.class)
public class AllayMixin {
    @ModifyReturnValue(method = "allayConsidersItemEqual", at = @At("RETURN"))
    private boolean mcsNations$hasNonMatchingItem(boolean original, ItemStack itemStack, ItemStack itemStack2) {
        return original && hasMatchingTCCItem(itemStack, itemStack2) && hasMatchingPufferItem(itemStack, itemStack2);
    }

    // The Creeper's Code
    @Unique
    private boolean hasMatchingTCCItem(ItemStack itemStack, ItemStack itemStack2) {
        Tag tccTag;
        Tag tccTag2;

        CustomData customData = itemStack.get(DataComponents.CUSTOM_DATA);
        CustomData customData2 = itemStack2.get(DataComponents.CUSTOM_DATA);

        if (customData != null) {
            tccTag = customData.copyTag().get("tcc");
            if (tccTag != null && tccTag.asString().isPresent()) {
                System.out.printf("Item 1: %s\n", tccTag.asString());
            } else {
                System.out.println("Item 1 has custom data but missing TCC Tag!");
            }
        } else {
            tccTag = null;
            System.out.println("Item 1 has no custom data.");
        }
        if (customData2 != null) {
            tccTag2 = customData2.copyTag().get("tcc");
            if (tccTag2 != null && tccTag2.asString().isPresent()) {
                System.out.printf("Item 2: %s\n", tccTag2.asString());
            } else {
                System.out.println("Item 2 has custom data but missing TCC Tag!");
            }
        } else {
            tccTag2 = null;
            System.out.println("Item 2 has no custom data.");
        }

        return Objects.equals(tccTag, tccTag2);
    }

    // MCS Puffer Praise Pack
    @Unique
    boolean hasMatchingPufferItem(ItemStack itemStack, ItemStack itemStack2) {
        // The datapack only uses pufferfish. If it's not a pufferfish, then it can't differ in the data.
        if (!itemStack.is(Items.PUFFERFISH) || !itemStack2.is(Items.PUFFERFISH)) return true;

        CustomModelData customModelData = itemStack.get(DataComponents.CUSTOM_MODEL_DATA);
        CustomModelData customModelData2 = itemStack2.get(DataComponents.CUSTOM_MODEL_DATA);
        return Objects.equals(customModelData, customModelData2);
    }
}
