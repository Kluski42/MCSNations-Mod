package net.wetnoodle.mcsnations.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.CustomModelData;
import net.wetnoodle.mcsnations.MCSNHelpers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

@Mixin(Allay.class)
public class AllayMixin {
    @ModifyReturnValue(method = "allayConsidersItemEqual", at = @At("RETURN"))
    private boolean mcsNations$hasNonMatchingItem(boolean original, ItemStack itemStack, ItemStack itemStack2) {
        return original && MCSNHelpers.equalDatapackItems(itemStack, itemStack2);
    }
}
