package net.wetnoodle.mcsnations.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Objects;

@Mixin(Allay.class)
public class AllayMixin {
    @ModifyReturnValue(method = "allayConsidersItemEqual", at = @At("RETURN"))
    private boolean mcsNations$hasNonMatchingItem(boolean original, ItemStack itemStack, ItemStack itemStack2) {
        return original && !hasNonMatchingTCCItem(itemStack, itemStack2);
    }

    @Unique
    private boolean hasNonMatchingTCCItem(ItemStack itemStack, ItemStack itemStack2) {
        Tag tccTag;
        Tag tccTag2;

        CustomData customData = itemStack.get(DataComponents.CUSTOM_DATA);
        CustomData customData2 = itemStack2.get(DataComponents.CUSTOM_DATA);

        if (customData != null) {
            tccTag = customData.copyTag().get("tcc");
        } else {
            tccTag = null;
        }
        if (customData2 != null) {
            tccTag2 = customData2.copyTag().get("tcc");
        } else {
            tccTag2 = null;
        }

        return !Objects.equals(tccTag, tccTag2);
    }
}
